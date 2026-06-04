package com.interviewmate.interview.mapper;

import com.interviewmate.interview.domain.Interview;
import org.apache.ibatis.annotations.Mapper;

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

}
