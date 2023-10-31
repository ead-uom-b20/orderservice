package com.lambda.orderservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseDto {
    private boolean status = true;
    private Object response;
    private String error = "";
}
