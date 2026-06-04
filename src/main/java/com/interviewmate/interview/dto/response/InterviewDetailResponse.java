package com.interviewmate.interview.dto.response;

import com.interviewmate.interview.domain.Interview;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class InterviewDetailResponse {

    private Long interviewId;

    private String title;

    private String jobRole;

    private String careerLevel;

    private String techStack;

    private String difficulty;

    private Integer questionCount;

    private String status;

    private Integer score;

    private LocalDateTime createdAt;

    public static InterviewDetailResponse from(
            Interview interview
    ) {
        return new InterviewDetailResponse(
                interview.getInterviewId(),
                interview.getTitle(),
                interview.getJobRole(),
                interview.getCareerLevel(),
                interview.getTechStack(),
                interview.getDifficulty(),
                interview.getQuestionCount(),
                interview.getStatus(),
                interview.getScore(),
                interview.getCreatedAt()
        );
    }
}