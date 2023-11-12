package com.lambda.orderservice.service.client;

import com.lambda.orderservice.dto.ResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "inventory-service", url = "http://localhost:8082/api/v1")
public interface InventoryServiceFeignClient {
    @GetMapping("/inventory/{id}")
    public ResponseDto findItemById(@PathVariable Long id);

    @GetMapping("/inventory/quantity/{id}")
    public Long findItemByIdQua(@PathVariable Long id);
}
