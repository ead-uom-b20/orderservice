package com.lambda.orderservice.service.client;

import com.lambda.orderservice.dto.ResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "identity-service", url = "http://localhost:8080/api/v1/identity")
public interface IdentityServiceFeignClient {
    @GetMapping("/user/{id}")
    public  ResponseDto getUserById(@PathVariable Long id);
}
