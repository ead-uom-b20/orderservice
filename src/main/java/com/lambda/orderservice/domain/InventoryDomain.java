package com.lambda.orderservice.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "inventory")
public class InventoryDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "productname")
    private String productName;

    @Column(name = "quantity")
    private Long quantity;

    @Column(name = "unitprice")
    private Double unitPrice;

    @Column(name = "status")
    private Integer status;

}
