package com.tolgaaksoy.inventoryservice.controller;

import com.tolgaaksoy.inventoryservice.service.InventoryService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping("/quantity/{skuCode}")
    public Integer getQuantity(@PathVariable String skuCode) {
        return inventoryService.getQuantity(skuCode);
    }

}
