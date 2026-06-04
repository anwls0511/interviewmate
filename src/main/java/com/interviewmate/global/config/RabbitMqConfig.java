package com.interviewmate.global.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    @Bean
    public Queue analysisQueue() {

        return new Queue(
                "analysis.queue",
                true
        );

    }

}