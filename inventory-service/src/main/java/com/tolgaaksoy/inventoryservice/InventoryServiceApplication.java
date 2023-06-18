package com.tolgaaksoy.inventoryservice;

import com.github.javafaker.Faker;
import com.tolgaaksoy.inventoryservice.model.Inventory;
import com.tolgaaksoy.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(InventoryRepository inventoryRepository) {

        if (inventoryRepository.count() == 0) {
            return args -> {
                Faker faker = new Faker();
                for (int i = 0; i < 100; i++) {
                    Inventory inventory = new Inventory();
                    String product = faker.commerce().productName().toLowerCase();
                    String skuCode = product.replace(" ", "_");
                    inventory.setSkuCode(skuCode);
                    inventory.setAvailableStock(faker.number().numberBetween(1, 100));
                    inventory.setReservedStock(faker.number().numberBetween(1, 100));
                    inventory.setStock(inventory.getAvailableStock() + inventory.getReservedStock());
                    inventoryRepository.save(inventory);
                }
            };
        } else {
            return args -> {
            };
        }
    }

}
