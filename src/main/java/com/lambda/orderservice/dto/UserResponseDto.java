package com.lambda.orderservice.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

import java.util.LinkedHashMap;

@Data
@Builder
public class UserResponseDto {

    @SerializedName("id")
    private Long id;
    @SerializedName("name")
    private String name;
    @SerializedName("email")
    private String email;
    @SerializedName("address")
    private String address;
    @SerializedName("nic")
    private String nic;
    @SerializedName("phone")
    private Integer phone;


}
