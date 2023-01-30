package kirinman.miniproject_kiosk.controller;


import kirinman.miniproject_kiosk.dto.*;
import kirinman.miniproject_kiosk.entity.Orders;
import kirinman.miniproject_kiosk.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/order")
    public TokenAccessDto saveOrder(@RequestBody List<Orders> ordersList, String phoneNumber, HttpServletResponse response) {
        return orderService.saveOrder(ordersList, phoneNumber, response);
    }

    @PostMapping("/order/bill")
    public OrderResponseDto totalPayment(@RequestBody TokenAccessDto token, HttpServletResponse response) {
        return orderService.totalPayment(token, response);
    }

    @PostMapping("/order/points")
    public StackPointResponseDto stackPoints(@RequestBody StackPointDto stackPointDto) {
        return orderService.stackPoints(stackPointDto);
    }

    @PostMapping("/order/dailySales")
    public Long dailySales(@RequestBody DailySalesRequestDto date) {
        return orderService.dailySales(date);
    }

    @GetMapping("/order/dailySales")
    public Long showDailySales(@RequestBody DailySalesRequestDto date) {
        return orderService.dailySales(date);
    }

    @GetMapping("/order/dailySales/details")
    public List<Orders> showDailySalesDetails(@RequestBody DailySalesRequestDto date){
        return orderService.showDailySalesDetails(date);
    }

}
