package com.lambda.orderservice.service.impl;

import com.google.gson.Gson;
import com.lambda.orderservice.domain.OrderDomain;
import com.lambda.orderservice.dto.GetOrderByIdResponseDto;
import com.lambda.orderservice.dto.ResponseDto;
import com.lambda.orderservice.dto.UserResponseDto;
import com.lambda.orderservice.repository.OrderRepository;
import com.lambda.orderservice.service.OrderService;
import com.lambda.orderservice.service.client.IdentityServiceFeignClient;
import com.lambda.orderservice.utils.ServiceUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ServiceUtil serviceUtil;
    private final IdentityServiceFeignClient identityServiceFeignClient;

    @Override
    public ResponseDto addNewOrder(OrderDomain orderDomain) {
        ResponseDto responseDto;
        try{
            orderDomain.setStatus("Order Placed");
            OrderDomain savedOrder = orderRepository.save(orderDomain);
            responseDto =  serviceUtil.getServiceResponse(savedOrder);
        } catch (Exception e){
            responseDto =  serviceUtil.getErrorServiceResponse("Can not create new order");
        }
        return responseDto;
    }

    @Override
    public ResponseDto getOrderById(Long id) {
        ResponseDto responseDto;
        try{
            Optional<OrderDomain> orderDomain = orderRepository.findById(id);

            if(orderDomain.isPresent()){
                OrderDomain order = orderDomain.get();
                ResponseDto userData = identityServiceFeignClient.getUserById((Long)order.getUserId());

                // Gson
//                Gson gson = new Gson();
//                UserResponseDto userResponseDto = gson.fromJson(userData.getResponse().toString(), UserResponseDto.class);
//                String username = userResponseDto.getFirstname();
                // Gson end

                responseDto =  serviceUtil.getServiceResponse(
                    GetOrderByIdResponseDto.builder()
                            .id(order.getId())
                            .productId((order.getProductId()))
                            .user(userData.getResponse())
                            .deliveryPersonId(order.getDeliveryPersonId())
                            .quantity(order.getQuantity())
                            .dateTime(order.getDateTime())
                            .status(order.getStatus())
                            .build()
                );

            }else{
                responseDto =  serviceUtil.getServiceResponse(null);
            }
        } catch (Exception e){
            responseDto =  serviceUtil.getErrorServiceResponse(String.valueOf(e));
        }
        return responseDto;
    }

    @Override
    public ResponseDto getOrdersByCustomerId(Long customerId) {
        ResponseDto responseDto;
        try{
            List<OrderDomain> orders = orderRepository.findAllByUserId(customerId);
            responseDto =  serviceUtil.getServiceResponse(orders);
        } catch (Exception e){
            responseDto =  serviceUtil.getErrorServiceResponse("Can not get order");
        }
        return responseDto;
    }

    @Override
    public ResponseDto getAllOrders() {
        ResponseDto responseDto;
        try{
            List<OrderDomain> orders = orderRepository.findAll();
            responseDto =  serviceUtil.getServiceResponse(orders);
        } catch (Exception e){
            responseDto =  serviceUtil.getErrorServiceResponse("Can not get orders");
        }
        return responseDto;
    }

    @Override
    public ResponseDto getAllOrdersByStatus(String status) {
        ResponseDto responseDto;
        try{
            List<OrderDomain> orders = orderRepository.findAllByStatus(status);
            responseDto =  serviceUtil.getServiceResponse(orders);
        } catch (Exception e){
            responseDto =  serviceUtil.getErrorServiceResponse("Can not get orders by status");
        }
        return responseDto;
    }
}
