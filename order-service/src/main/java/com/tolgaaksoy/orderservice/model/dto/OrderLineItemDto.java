package com.tolgaaksoy.orderservice.model.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderLineItemDto {

    private String skuCode;
    private Integer quantity;
    private BigDecimal price;

}
