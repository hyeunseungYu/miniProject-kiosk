package kirinman.miniproject_kiosk.service;//package miniProject.kiosk.service;
//
//import miniProject.kiosk.entity.OrderNumber;
//import miniProject.kiosk.entity.Orders;
//import miniProject.kiosk.jwt.JwtUtil;
//import miniProject.kiosk.repository.OrderNumberRepository;
//import miniProject.kiosk.dto.OrderNumberDto;
//import jakarta.transaction.Transactional;
//import lombok.RequiredArgsConstructor;
//import miniProject.kiosk.repository.OrderRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//
//@Service
//@RequiredArgsConstructor
//public class OrderNumberService {
//
//    private final OrderNumberRepository orderNumberRepository;
//    private final JwtUtil jwtUtil;
//    private final OrderRepository orderRepository;
//
//    @Transactional
//    public OrderNumber Numbering(Long orderId) {
//        //주문ID는 주문 대기번호가 200번까지 발급한다.
//        Optional<Orders> ordernum = orderRepository.findById(orderId);
//
//        //주문 id
//        if(ordernum <= 200) {
//            for (ordernum = 0; ordernum <= 200; ordernum++) {
//                ordernum = ordernum + 1;
//
//            }else{
//                ordernum = 0;
//            }
//
//            return ordernum;
//        }
//
//        @Transactional
//        public OrderNumber Waiting(OrderNumber ordernum) {
//            //주문번호가 메뉴당 걸리는 요리시간에 따라, 걸리는 대기시간 (현재 완료된 버거 확인) 총 14개 메뉴
//            List<Integer> cooktime = Arrays.asList(1,2,3,2,1,2,3,2,1,2,3,1,2,3); // 임의 시간 생성
//            OrderNumber on = new OrderNumber();
//            on.getOrderNum = ordernum;
//            on.getWaitingNum = cooktime; // 요리시간
//
//            return on;
//        }
//
//    }