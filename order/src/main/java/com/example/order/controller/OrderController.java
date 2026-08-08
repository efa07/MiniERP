package com.example.order.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @PostMapping
    public String createOrder(
            @RequestParam Long productId
    ) {

        return "Order created for product " + productId;
    }
}