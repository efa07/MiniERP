package com.example.order.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String EXCHANGE =
            "erp.exchange";

    public static final String ORDER_QUEUE =
            "order.created.queue";

    public static final String ORDER_CREATED_ROUTING_KEY =
            "order.created";

    @Bean
    public DirectExchange erpExchange() {
        return new DirectExchange(EXCHANGE);
    }

    @Bean
    public Queue orderCreatedQueue() {
        return new Queue(ORDER_QUEUE);
    }

    @Bean
    public Binding orderCreatedBinding(
            Queue orderCreatedQueue,
            DirectExchange erpExchange
    ) {

        return BindingBuilder
                .bind(orderCreatedQueue)
                .to(erpExchange)
                .with(ORDER_CREATED_ROUTING_KEY);
    }
}