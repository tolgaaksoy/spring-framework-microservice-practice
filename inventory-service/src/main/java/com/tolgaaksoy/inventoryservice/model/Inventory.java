package com.tolgaaksoy.inventoryservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity(name = "inventory")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {

    @Id
    private Long id;
    private String skuCode;
    private Integer stock;
    private Integer reservedStock;
    private Integer availableStock;

}
