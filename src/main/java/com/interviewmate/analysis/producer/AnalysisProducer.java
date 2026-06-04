package com.interviewmate.analysis.producer;

import com.interviewmate.analysis.dto.AnalysisMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AnalysisProducer {

    private final RabbitTemplate rabbitTemplate;

    public void send(
            AnalysisMessage message
    ) {

        rabbitTemplate.convertAndSend(
                "analysis.queue",
                message
        );

    }

}