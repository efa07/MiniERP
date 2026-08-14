package com.example.order.controller;

import com.example.order.event.OrderCreatedEvent;
import com.example.order.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(
            OrderService orderService
    ) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderCreatedEvent> createOrder(
            @RequestParam Long productId,
            @RequestParam Integer quantity
    ) {

        OrderCreatedEvent event =
                orderService.createOrder(
                        productId,
                        quantity
                );

        return ResponseEntity.ok(event);
    }
}