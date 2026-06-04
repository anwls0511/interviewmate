package com.interviewmate.interview.service;

import com.interviewmate.interview.domain.Interview;
import com.interviewmate.interview.dto.request.InterviewCreateRequest;
import com.interviewmate.interview.dto.response.InterviewResponse;
import com.interviewmate.interview.mapper.InterviewMapper;
import com.interviewmate.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InterviewService {

    private final InterviewMapper interviewMapper;

    private final QuestionService questionService;

    public InterviewResponse createInterview(
            Long userId,
            InterviewCreateRequest request
    ) {

        Interview interview =
                new Interview();

        interview.setUserId(userId);

        interview.setTitle(request.getTitle());

        interview.setJobRole(request.getJobRole());

        interview.setCareerLevel(
                request.getCareerLevel()
        );

        interview.setTechStack(
                request.getTechStack()
        );

        interview.setDifficulty(
                request.getDifficulty()
        );

        interview.setQuestionCount(
                request.getQuestionCount()
        );

        interviewMapper.insertInterview(
                interview
        );

        questionService.createDefaultQuestions(
                interview.getInterviewId(),
                interview.getDifficulty()
        );

        return new InterviewResponse(
                interview.getInterviewId(),
                interview.getTitle(),
                "READY"
        );

    }

}
