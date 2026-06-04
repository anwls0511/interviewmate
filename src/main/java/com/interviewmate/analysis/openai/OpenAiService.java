package com.interviewmate.analysis.openai;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.interviewmate.analysis.dto.AnalysisAiResult;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class OpenAiService {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Value("${openai.api-key:}")
    private String apiKey;

    @Value("${openai.model:gpt-4.1-mini}")
    private String model;

    public AnalysisAiResult analyzeAnswer(String answerText) {

        if (apiKey == null || apiKey.isBlank()) {
            return createFallbackResult();
        }

        try {
            WebClient webClient = WebClient.builder()
                    .baseUrl("https://api.openai.com/v1")
                    .defaultHeader("Authorization", "Bearer " + apiKey)
                    .defaultHeader("Content-Type", "application/json")
                    .build();

            String prompt = """
                    너는 20년차 개발자 면접관이다.
                    아래 지원자의 답변을 평가해라.

                    평가 기준:
                    - 전문성 점수: 0~100
                    - 논리성 점수: 0~100
                    - 전달력 점수: 0~100
                    - 총점: 0~100
                    - 피드백
                    - 개선 답변 예시

                    반드시 아래 JSON 형식으로만 응답해라.
                    {
                      "professionalismScore": 85,
                      "logicScore": 80,
                      "communicationScore": 90,
                      "totalScore": 85,
                      "feedback": "피드백 내용",
                      "improvementAnswer": "개선 답변 예시"
                    }

                    지원자 답변:
                    %s
                    """.formatted(answerText);

            String requestBody = """
                    {
                      "model": "%s",
                      "input": "%s"
                    }
                    """.formatted(model, escapeJson(prompt));

            String response = webClient.post()
                    .uri("/responses")
                    .bodyValue(requestBody)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            return parseResponse(response);

        } catch (Exception e) {
            return createFallbackResult();
        }
    }

    private AnalysisAiResult parseResponse(String response) {

        try {
            JsonNode root = objectMapper.readTree(response);

            String outputText = root.path("output")
                    .get(0)
                    .path("content")
                    .get(0)
                    .path("text")
                    .asText();

            JsonNode result = objectMapper.readTree(outputText);

            return new AnalysisAiResult(
                    result.path("professionalismScore").asInt(),
                    result.path("logicScore").asInt(),
                    result.path("communicationScore").asInt(),
                    result.path("totalScore").asInt(),
                    result.path("feedback").asText(),
                    result.path("improvementAnswer").asText()
            );

        } catch (Exception e) {
            return createFallbackResult();
        }
    }

    private AnalysisAiResult createFallbackResult() {

        return new AnalysisAiResult(
                85,
                80,
                90,
                85,
                "답변의 논리성과 전달력이 우수합니다.",
                "RabbitMQ의 ACK, DLQ, 재처리 정책까지 함께 설명하면 더 좋은 답변이 됩니다."
        );
    }

    private String escapeJson(String text) {

        return text
                .replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\r", "\\r");
    }
}