package com.tolgaaksoy.orderservice.service.impl;

import com.tolgaaksoy.orderservice.model.dto.request.OrderRequest;
import com.tolgaaksoy.orderservice.model.entity.Order;
import com.tolgaaksoy.orderservice.model.entity.OrderLineItem;
import com.tolgaaksoy.orderservice.repository.OrderRepository;
import com.tolgaaksoy.orderservice.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;


    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        orderRequest.getOrderLineItemList().forEach(orderLineItemDto ->
                order.getOrderLineItemList().add(OrderLineItem.builder()
                        .skuCode(orderLineItemDto.getSkuCode())
                        .quantity(orderLineItemDto.getQuantity())
                        .price(orderLineItemDto.getPrice())
                        .build()));

        orderRepository.save(order);

        log.info("Order Placed Successfully");
    }
}
