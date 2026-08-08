package com.example.order.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class InventoryClient {
    
    private final RestClient restClient;

    public InventoryClient() {
        this.restClient = RestClient.builder()
                .baseUrl("http://localhost:8082")
                .build();
    }

    public boolean reserveStock(Long productId) {
        restClient
                .post()
                .uri("/api/inventory/{productId}/reserve", productId)
                .retrieve()
                .body(String.class);
        return true;
    }
}
