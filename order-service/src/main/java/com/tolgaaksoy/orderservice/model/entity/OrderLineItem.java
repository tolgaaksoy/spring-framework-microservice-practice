package com.tolgaaksoy.orderservice.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderLineItem {

    @Id
    private Long id;

    //stock keeping unit
    private String skuCode;

    private Integer quantity;
    private BigDecimal price;

}
