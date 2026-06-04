package com.interviewmate.question.service;

import com.interviewmate.question.domain.Question;
import com.interviewmate.question.dto.response.QuestionResponse;
import com.interviewmate.question.mapper.QuestionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionMapper questionMapper;

    public void createDefaultQuestions(
            Long interviewId,
            String difficulty
    ) {
        List<String> contents = List.of(
                "Java의 JVM 메모리 구조에 대해 설명해주세요.",
                "Spring에서 DI와 IoC의 차이를 설명해주세요.",
                "MyBatis를 사용하는 이유와 장단점을 설명해주세요.",
                "Redis를 캐시로 사용할 때 주의할 점은 무엇인가요?",
                "RabbitMQ를 사용한 이유와 장애 시 대응 방식을 설명해주세요."
        );

        for (int i = 0; i < contents.size(); i++) {
            Question question = new Question();

            question.setInterviewId(interviewId);
            question.setContent(contents.get(i));
            question.setQuestionOrder(i + 1);
            question.setDifficulty(difficulty);
            question.setQuestionType("TECH");

            questionMapper.insertQuestion(question);
        }
    }

    public List<QuestionResponse> getQuestions(
            Long interviewId
    ) {
        return questionMapper.findByInterviewId(interviewId)
                .stream()
                .map(QuestionResponse::from)
                .toList();
    }
}