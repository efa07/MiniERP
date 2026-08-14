package com.example.order.event;

import java.util.UUID;

public class OrderCreatedEvent {

    private UUID eventId;
    private Long orderId;
    private Long productId;
    private Integer quantity;

    public OrderCreatedEvent() {
    }

    public OrderCreatedEvent(
            UUID eventId,
            Long orderId,
            Long productId,
            Integer quantity
    ) {
        this.eventId = eventId;
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public UUID getEventId() {
        return eventId;
    }

    public void setEventId(UUID eventId) {
        this.eventId = eventId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}