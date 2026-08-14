package com.example.order.service;

import com.example.order.event.OrderCreatedEvent;
import com.example.order.messaging.OrderEventPublisher;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class OrderService {

    private final OrderEventPublisher eventPublisher;

    private final AtomicLong orderIdGenerator =
            new AtomicLong(1000);

    public OrderService(
            OrderEventPublisher eventPublisher
    ) {
        this.eventPublisher = eventPublisher;
    }

    public OrderCreatedEvent createOrder(
            Long productId,
            Integer quantity
    ) {

        Long orderId =
                orderIdGenerator.incrementAndGet();

        OrderCreatedEvent event =
                new OrderCreatedEvent(
                        UUID.randomUUID(),
                        orderId,
                        productId,
                        quantity
                );

        eventPublisher.publishOrderCreated(event);

        return event;
    }
}