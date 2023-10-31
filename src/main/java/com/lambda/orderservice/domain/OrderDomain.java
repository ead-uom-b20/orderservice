package com.lambda.orderservice.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "orders")
public class OrderDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "productId")
    private Long productId;

    @Column(name = "userId")
    private Long userId;

    @Column(name = "deliveryPersonId")
    private Long deliveryPersonId;

    @Column(name = "quantity")
    private Long quantity;

    @Column(name = "dateTime")
    private LocalDateTime dateTime;

    @Column(name = "status")
    private String status;

    @PrePersist
    private void setDefaultDateTime() {
        if (dateTime == null) {
            dateTime = LocalDateTime.now();
        }
    }
}
