package com.tolgaaksoy.inventoryservice.service.impl;

import com.tolgaaksoy.inventoryservice.repository.InventoryRepository;
import com.tolgaaksoy.inventoryservice.service.InventoryService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

@Service
@Slf4j
public class InventoryServiceImpl implements InventoryService {

  private final InventoryRepository inventoryRepository;

  public InventoryServiceImpl(InventoryRepository inventoryRepository) {
    this.inventoryRepository = inventoryRepository;
  }


}
