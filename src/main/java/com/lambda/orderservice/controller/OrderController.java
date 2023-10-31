package com.lambda.orderservice.controller;

import com.lambda.orderservice.domain.OrderDomain;
import com.lambda.orderservice.dto.ResponseDto;
import com.lambda.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/order")
    public ResponseDto addNewOrder(@RequestBody OrderDomain orderDomain){
        return orderService.addNewOrder(orderDomain);
    }

    @GetMapping("/order/{id}")
    public ResponseDto getOrderById(@PathVariable Long id){
        return orderService.getOrderById(id);
    }

    @GetMapping("/orders/{customerId}")
    public  ResponseDto getOrdersByCustomerId(@PathVariable Long customerId){
        return orderService.getOrdersByCustomerId(customerId);
    }

    @GetMapping("/orders")
    public ResponseDto getAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping ("/orders/status/{status}")
    ResponseDto getAllOrdersByStatus(@PathVariable String status){
        return orderService.getAllOrdersByStatus(status);
    }
}
