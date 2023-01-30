package kirinman.miniproject_kiosk.service;

import io.jsonwebtoken.Claims;
import kirinman.miniproject_kiosk.dto.*;
import kirinman.miniproject_kiosk.dto.member.UpdatePointDto;
import kirinman.miniproject_kiosk.entity.*;
import kirinman.miniproject_kiosk.jwt.JwtUtil;
import kirinman.miniproject_kiosk.repository.MemberRepository;
import kirinman.miniproject_kiosk.repository.MenuRepository;
import kirinman.miniproject_kiosk.repository.OrderNumberRepository;
import kirinman.miniproject_kiosk.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {
    private final MemberRepository memberRepository;
    private final JwtUtil jwtUtil;
    private final OrderRepository orderRepository;
    private final MenuRepository menuRepository;
    private final OrderNumberRepository orderNumberRepository;

    public OrderResponseDto totalPayment(TokenAccessDto token, HttpServletResponse response) {

        // Request에서 Token 가져오기
        log.info("requestToken = " + token.getAuthorization());
        String tokens = token.getAuthorization().substring(7);
        log.info("Token = " + tokens);
        Claims claims;

        if (token != null) {
            claims = jwtUtil.getUserInfoFromToken(tokens);
//            if (jwtUtil.validateToken(token)) {
//                // 토큰에서 사용자 정보 가져오기
//
//
//            } else {
//                throw new IllegalArgumentException("주문 신청에 오류가 있습니다.");
//            }

            String time = (String) claims.get("time");
            log.info("시간정보입니다 " + time);

            List<Orders> targetOrders = orderRepository.findAllByCreatedAt(time);
            log.info(targetOrders.toString());

            Integer sum = 0;

            for (Orders targetOrder : targetOrders) {
                Menu targetMenu = targetOrder.getMenu();
                Integer price = targetMenu.getPrice() * targetOrder.getAmount();
                sum += price;
            }
            return new OrderResponseDto(sum);
        } else {
            throw new IllegalArgumentException("토큰이 확인되지 않음");
        }
    }

    public TokenAccessDto saveOrder(List<Orders> ordersList, String phoneNumber, HttpServletResponse response) {

        int sum = 0;

        for (Orders orders : ordersList) {
            Menu menu = menuRepository.findByMenuName(orders.getMenuName());

            if (menu == null) {
                throw new IllegalArgumentException("메뉴 정보를 찾을 수 없습니다");

            } else {
                Orders orders1 = Orders.builder()
                        .menuName(orders.getMenuName())
                        .amount(orders.getAmount())
                        .imageUrl(menu.getImageUrl())
                        .menu(menu)
                        .build();
                orderRepository.save(orders1);
                sum += menu.getPrice();
                log.info("가격확인" + sum);
            }
        }

        String token = jwtUtil.createToken(MemberRoleEnum.MEMBER);

        OrderNumberRequestDto orderNumberRequestDto = new OrderNumberRequestDto();
        orderNumberRequestDto.setOrderCnt(orderNumberRequestDto.getOrderCnt());
        OrderNumber orderNumber = new OrderNumber(orderNumberRequestDto);

        orderNumberRepository.save(orderNumber);

        response.addHeader(JwtUtil.AUTHORIZATION_HEADER, token);
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");

        return new TokenAccessDto(token);
    }

    @Transactional
    public StackPointResponseDto stackPoints(StackPointDto stackPointDto) {


        String tokens = stackPointDto.getToken().substring(7);
        Claims claims;

        log.info("폰넘버 = " + stackPointDto.getPhoneNumber());
        Member member = memberRepository.findByPhoneNumber(stackPointDto.getPhoneNumber());

        if ((tokens != null) && member != null) {
            if (jwtUtil.validateToken(tokens)) {
                // 토큰에서 사용자 정보 가져오기
                claims = jwtUtil.getUserInfoFromToken(tokens);
            } else {
                throw new IllegalArgumentException("주문 신청에 오류가 있습니다.");
            }

            String time = (String) claims.get("time");
            log.info("시간정보입니다 " + time);

            List<Orders> targetOrders = orderRepository.findAllByCreatedAt(time);

            Integer sum = 0;

            for (Orders targetOrder : targetOrders) {
                Menu targetMenu = targetOrder.getMenu();
                Integer price = targetMenu.getPrice() * targetOrder.getAmount();
                sum += price;
            }
            log.info("sum = " + sum);
            double point = sum * ((double) 5 / 100);
            UpdatePointDto updatePointDto = new UpdatePointDto((int) point);

            log.info("point = " + point);
            member.updatePoint(updatePointDto);
            return new StackPointResponseDto((int) point);

        } else {
            throw new IllegalArgumentException("토큰이 확인되지 않음");
        }
    }

    @Transactional
    public Long dailySales(DailySalesRequestDto date) {
        List<Orders> orders = orderRepository.findAllByCreatedAtContains(date.getDate());
        log.info("date = " + date);
        log.info("orders = " + orders);

        long sum = 0;

        for (Orders order : orders) {
            sum += order.getMenu().getPrice() * (order.getAmount());
        }

        return sum;
    }

    public OrderNumberRequestDto cntOrder() {
        Long cnt = orderNumberRepository.countBy();
        return new OrderNumberRequestDto(cnt);
    }

    public List<Orders> showDailySalesDetails(DailySalesRequestDto date) {
        return orderRepository.findAllByCreatedAtContains(date.getDate());
    }
}
