package kirinman.miniproject_kiosk.controller;

//import miniProject.kiosk.dto.OrderNumberDto;

import kirinman.miniproject_kiosk.dto.OrderNumberRequestDto;
import kirinman.miniproject_kiosk.service.OrderService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderNumberController {

    private final OrderService orderService;

    // dev jun23
    @GetMapping("/order/orderNumber") // 주문번호 생성
    public OrderNumberRequestDto cntOrder() {
        return orderService.cntOrder();
    }

    // dev jun23
//    @GetMapping("/order/waiting-number")
//    public OrderNumberDto waitingnumber(@RequestBody OrderNumber orderNum) {
//        OrderNumber waitingnum = orderNumberService.Waiting(number, orderNum);
//        return new OrderNumberDto(waitingnum); //
//    }


}