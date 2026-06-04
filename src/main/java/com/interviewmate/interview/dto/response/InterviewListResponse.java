package com.interviewmate.interview.dto.response;

import com.interviewmate.interview.domain.Interview;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class InterviewListResponse {

    private Long interviewId;

    private String title;

    private String jobRole;

    private String difficulty;

    private String status;

    private Integer score;

    private LocalDateTime createdAt;

    public static InterviewListResponse from(
            Interview interview
    ) {
        return new InterviewListResponse(
                interview.getInterviewId(),
                interview.getTitle(),
                interview.getJobRole(),
                interview.getDifficulty(),
                interview.getStatus(),
                interview.getScore(),
                interview.getCreatedAt()
        );
    }
}