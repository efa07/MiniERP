package com.example.order.messaging;

import com.example.order.config.RabbitMQConfig;
import com.example.order.event.OrderCreatedEvent;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderEventPublisher {

    private final RabbitTemplate rabbitTemplate;

    public OrderEventPublisher(
            RabbitTemplate rabbitTemplate
    ) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publishOrderCreated(
            OrderCreatedEvent event
    ) {

        rabbitTemplate.convertAndSend(
                RabbitMQConfig.EXCHANGE,
                RabbitMQConfig.ORDER_CREATED_ROUTING_KEY,
                event
        );
    }
}