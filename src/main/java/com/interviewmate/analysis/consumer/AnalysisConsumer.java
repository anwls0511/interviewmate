package com.interviewmate.analysis.consumer;

import com.interviewmate.analysis.dto.AnalysisMessage;
import com.interviewmate.analysis.service.AnalysisService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class AnalysisConsumer {

    private final AnalysisService analysisService;

    @RabbitListener(queues = "analysis.queue")
    public void consume(
            AnalysisMessage message
    ) {

        log.info(
                "분석 요청 수신 interviewId={}",
                message.getInterviewId()
        );

        analysisService.analyze(
                message
        );

    }

}