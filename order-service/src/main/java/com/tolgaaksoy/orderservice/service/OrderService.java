package com.tolgaaksoy.orderservice.service;

import com.tolgaaksoy.orderservice.model.dto.request.OrderRequest;

public interface OrderService {
    void placeOrder(OrderRequest orderRequest);
}
