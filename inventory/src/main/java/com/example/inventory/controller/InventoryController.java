package com.example.inventory.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @GetMapping("/{productId}")
    public String getInventory(
            @PathVariable Long productId
    ) {

        return "Product " + productId + " has 100 items in stock";
    }

    @PostMapping("/{productId}/reserve")
    public String reserveStock(
            @PathVariable Long productId
    ) {

        return "Stock reserved for product " + productId;
    }
}