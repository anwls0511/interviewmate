package com.interviewmate.analysis.service;

import com.interviewmate.analysis.domain.Analysis;
import com.interviewmate.analysis.dto.AnalysisMessage;
import com.interviewmate.analysis.mapper.AnalysisMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.interviewmate.analysis.dto.response.AnalysisResultResponse;
import com.interviewmate.global.exception.BusinessException;
import com.interviewmate.global.exception.ErrorCode;

@Service
@RequiredArgsConstructor
public class AnalysisService {

    private final AnalysisMapper analysisMapper;

    public void analyze(
            AnalysisMessage message
    ) {

        Analysis analysis =
                new Analysis();

        analysis.setInterviewId(
                message.getInterviewId()
        );

        analysis.setAnswerId(
                message.getAnswerId()
        );

        analysis.setUserId(
                message.getUserId()
        );

        // 임시 점수
        analysis.setProfessionalismScore(85);

        analysis.setLogicScore(80);

        analysis.setCommunicationScore(90);

        analysis.setTotalScore(85);

        analysis.setFeedback(
                "답변의 논리성과 전달력이 우수합니다."
        );

        analysis.setImprovementAnswer(
                "RabbitMQ의 ACK와 DLQ 구조까지 설명하면 더욱 좋습니다."
        );

        analysis.setStatus("COMPLETED");

        analysisMapper.insertAnalysis(
                analysis
        );

    }

    public AnalysisResultResponse getResult(
            Long interviewId
    ) {

        Analysis analysis =
                analysisMapper.findByInterviewId(
                        interviewId
                );

        if (analysis == null) {

            throw new BusinessException(
                    ErrorCode.ANALYSIS_NOT_FOUND
            );

        }

        return AnalysisResultResponse.from(
                analysis
        );

    }

}