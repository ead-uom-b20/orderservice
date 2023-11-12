package com.lambda.orderservice.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InventoryResponseDto {
    @SerializedName("id")
    private Long id;

    @SerializedName("productName")
    private String productName;

    @SerializedName("quantity")
    private Long quantity;

    @SerializedName("unitPrice")
    private Double unitPrice;

    @SerializedName("status")
    private  Integer status;
}
