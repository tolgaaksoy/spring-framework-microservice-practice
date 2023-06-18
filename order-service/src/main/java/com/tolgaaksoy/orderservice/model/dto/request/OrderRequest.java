package com.tolgaaksoy.orderservice.model.dto.request;

import com.tolgaaksoy.orderservice.model.dto.OrderLineItemDto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {

    private List<OrderLineItemDto> orderLineItemList;

}
