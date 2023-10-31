package com.lambda.orderservice.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Builder
public class GetOrderByIdResponseDto {
    private long id;
    private Long productId;
    private Object user;
    private Long deliveryPersonId;
    private Long quantity;
    private LocalDateTime dateTime;
    private String status;
}
