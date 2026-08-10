package com.example.order.controller;

import com.example.order.messaging.OrderEventPublisher;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderEventPublisher publisher;

    public OrderController(
            OrderEventPublisher publisher
    ) {
        this.publisher = publisher;
    }

    @PostMapping
    public String createOrder(
            @RequestParam Long productId
    ) {

        String message =
                "Order created for product " + productId;

        publisher.publishOrderCreated(message);

        return message;
    }
}