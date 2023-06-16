package com.tolgaaksoy.inventoryservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Table;

@Table(name = "inventory")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {

  private Long id;
  private String skuCode;
  private Integer stock;
  private Integer reservedStock;
  private Integer availableStock;

}
