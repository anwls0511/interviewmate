package com.interviewmate.question.dto.response;

import com.interviewmate.question.domain.Question;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class QuestionResponse {

    private Long questionId;
    private String content;
    private Integer questionOrder;
    private String difficulty;
    private String questionType;

    public static QuestionResponse from(Question question) {
        return new QuestionResponse(
                question.getQuestionId(),
                question.getContent(),
                question.getQuestionOrder(),
                question.getDifficulty(),
                question.getQuestionType()
        );
    }
}