package com.interviewmate.analysis.openai;

import com.interviewmate.analysis.dto.AnalysisAiResult;
import org.springframework.stereotype.Service;

@Service
public class OpenAiService {

    public AnalysisAiResult analyzeAnswer(String answerText) {

        // TODO: 실제 OpenAI API 연동 전 임시 분석 결과
        return new AnalysisAiResult(
                85,
                80,
                90,
                85,
                "답변의 논리성과 전달력이 우수합니다.",
                "RabbitMQ의 ACK, DLQ, 재처리 정책까지 함께 설명하면 더 좋은 답변이 됩니다."
        );
    }
}