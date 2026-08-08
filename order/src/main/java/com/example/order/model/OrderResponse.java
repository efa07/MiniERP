package com.example.order.model;

public class OrderResponse {

    private String message;
    private Long productId;
    private int quantity;
    private boolean inventoryReserved;

    public OrderResponse() {
    }

    public OrderResponse(String message, Long productId, int quantity, boolean inventoryReserved) {
        this.message = message;
        this.productId = productId;
        this.quantity = quantity;
        this.inventoryReserved = inventoryReserved;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isInventoryReserved() {
        return inventoryReserved;
    }

    public void setInventoryReserved(boolean inventoryReserved) {
        this.inventoryReserved = inventoryReserved;
    }
}