package com.example.inventory.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class OrderEventConsumer {

    @RabbitListener(queues = "order.queue")
    public void consume(String message) {

        System.out.println(
                "Received order event: " + message
        );
    }

}