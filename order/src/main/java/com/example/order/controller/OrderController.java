package com.example.order.controller;

import com.example.order.model.OrderRequest;
import com.example.order.model.OrderResponse;
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
    public OrderResponse createOrder(
            @RequestBody OrderRequest orderRequest
    ) {

        boolean inventoryReserved =
                inventoryClient.reserveStock(orderRequest.getProductId());

        return new OrderResponse(
                "Order created",
                orderRequest.getProductId(),
                orderRequest.getQuantity(),
                inventoryReserved
        );
    }
}