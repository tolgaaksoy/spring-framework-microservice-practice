package com.tolgaaksoy.orderservice.service.impl;

import com.tolgaaksoy.orderservice.model.dto.OrderLineItemDto;
import com.tolgaaksoy.orderservice.model.dto.request.OrderRequest;
import com.tolgaaksoy.orderservice.model.entity.Order;
import com.tolgaaksoy.orderservice.model.entity.OrderLineItem;
import com.tolgaaksoy.orderservice.repository.OrderRepository;
import com.tolgaaksoy.orderservice.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final WebClient webClient;

    public OrderServiceImpl(OrderRepository orderRepository, WebClient webClient) {
        this.orderRepository = orderRepository;
        this.webClient = webClient;
    }

    @Override
    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItem> orderLineItemList = new ArrayList<>(orderRequest.getOrderLineItemList().size());

        for (OrderLineItemDto orderLineItemDto : orderRequest.getOrderLineItemList()) {
            if (!checkStock(orderLineItemDto)) {
                log.warn("Insufficient Stock");
                continue;
                //throw new RuntimeException("Insufficient Stock");
            }
            OrderLineItem orderLineItem = new OrderLineItem();
            orderLineItem.setQuantity(orderLineItemDto.getQuantity());
            orderLineItem.setSkuCode(orderLineItemDto.getSkuCode());
            orderLineItemList.add(orderLineItem);
        }

        order.setOrderLineItemList(orderLineItemList);

        orderRepository.save(order);

        log.info("Order Placed Successfully");
    }

    private boolean checkStock(OrderLineItemDto orderLineItemDto) {
        Integer stock = webClient.get()
                .uri("http://localhost:8082/api/inventory/quantitu/{skuCode}", orderLineItemDto.getSkuCode())
                .retrieve()
                .bodyToMono(Integer.class)
                .block();
        if (stock == null) {
            return false;
        }
        return stock > 0;
    }
}
