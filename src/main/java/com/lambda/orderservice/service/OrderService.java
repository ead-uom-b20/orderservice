package com.lambda.orderservice.service;

import com.lambda.orderservice.domain.OrderDomain;
import com.lambda.orderservice.dto.ResponseDto;

public interface OrderService {
    ResponseDto addNewOrder(OrderDomain orderDomain);
    ResponseDto getOrderById(Long id);
    ResponseDto getOrdersByCustomerId(Long customerId);
    ResponseDto getAllOrders();
    ResponseDto getAllOrdersByStatus(String status);
}
