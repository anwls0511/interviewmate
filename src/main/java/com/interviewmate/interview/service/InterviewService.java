package com.interviewmate.interview.service;

import com.interviewmate.auth.domain.User;
import com.interviewmate.global.exception.BusinessException;
import com.interviewmate.global.exception.ErrorCode;
import com.interviewmate.global.response.PageResponse;
import com.interviewmate.interview.domain.Interview;
import com.interviewmate.interview.dto.request.InterviewCreateRequest;
import com.interviewmate.interview.dto.response.InterviewDetailResponse;
import com.interviewmate.interview.dto.response.InterviewFinishResponse;
import com.interviewmate.interview.dto.response.InterviewListResponse;
import com.interviewmate.interview.dto.response.InterviewResponse;
import com.interviewmate.interview.mapper.InterviewMapper;
import com.interviewmate.question.service.QuestionService;
import com.interviewmate.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.interviewmate.interview.dto.request.InterviewSearchRequest;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InterviewService {

    private final InterviewMapper interviewMapper;

    private final QuestionService questionService;

    private final UserMapper userMapper;

    public InterviewResponse createInterview(
            Long userId,
            InterviewCreateRequest request
    ) {

        User user = userMapper.findById(userId);

        if (user == null) {
            throw new BusinessException(
                    ErrorCode.USER_NOT_FOUND
            );
        }

        if ("FREE".equals(user.getPlanType())) {

            int todayInterviewCount =
                    interviewMapper.countTodayByUserId(userId);

            if (todayInterviewCount >= 3) {
                throw new BusinessException(
                        ErrorCode.FREE_PLAN_DAILY_LIMIT_EXCEEDED
                );
            }
        }

        Interview interview = new Interview();

        interview.setUserId(userId);
        interview.setTitle(request.getTitle());
        interview.setJobRole(request.getJobRole());
        interview.setCareerLevel(request.getCareerLevel());
        interview.setTechStack(request.getTechStack());
        interview.setDifficulty(request.getDifficulty());
        interview.setQuestionCount(request.getQuestionCount());

        interviewMapper.insertInterview(interview);

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

    public PageResponse<InterviewListResponse> getMyInterviews(
            Long userId,
            InterviewSearchRequest request
    ) {
        int totalCount =
                interviewMapper.countByUserId(userId);

        List<InterviewListResponse> interviews =
                interviewMapper.findByUserId(userId, request)
                        .stream()
                        .map(InterviewListResponse::from)
                        .toList();

        return new PageResponse<>(
                totalCount,
                request.getPage(),
                request.getSize(),
                interviews
        );
    }

    public InterviewDetailResponse getInterviewDetail(
            Long interviewId
    ) {

        Interview interview =
                interviewMapper.findById(interviewId);

        if (interview == null) {
            throw new BusinessException(
                    ErrorCode.INTERVIEW_NOT_FOUND
            );
        }

        return InterviewDetailResponse.from(interview);
    }

    public InterviewFinishResponse finishInterview(
            Long interviewId
    ) {
        Interview interview =
                interviewMapper.findById(interviewId);

        if (interview == null) {
            throw new BusinessException(
                    ErrorCode.INTERVIEW_NOT_FOUND
            );
        }

        interviewMapper.updateStatusToCompleted(interviewId);

        return new InterviewFinishResponse(
                interviewId,
                "COMPLETED"
        );
    }
}