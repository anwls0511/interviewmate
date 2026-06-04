package com.interviewmate.interview.mapper;

import com.interviewmate.interview.domain.Interview;
import org.apache.ibatis.annotations.Mapper;
import com.interviewmate.interview.dto.request.InterviewSearchRequest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface InterviewMapper {

    int insertInterview(
            Interview interview
    );

    Interview findById(
            Long interviewId
    );

    List<Interview> findByUserId(Long userId);

    int updateStatusToCompleted(Long interviewId);

    int countTodayByUserId(Long userId);

    List<Interview> findByUserId(
            @Param("userId") Long userId,
            @Param("request") InterviewSearchRequest request
    );

    int countByUserId(Long userId);

}
