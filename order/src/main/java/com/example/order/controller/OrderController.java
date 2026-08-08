package com.example.order.controller;

import com.example.order.service.InventoryClient;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final InventoryClient inventoryClient;

    public OrderController(
            InventoryClient inventoryClient
    ) {
        this.inventoryClient = inventoryClient;
    }

    @PostMapping
    public String createOrder(
            @RequestParam Long productId
    ) {

        String inventoryResponse =
                inventoryClient.reserveStock(productId);

        return "Order created. " + inventoryResponse;
    }
}