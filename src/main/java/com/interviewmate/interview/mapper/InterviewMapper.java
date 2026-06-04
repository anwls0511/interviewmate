package com.interviewmate.interview.mapper;

import com.interviewmate.interview.domain.Interview;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InterviewMapper {

    int insertInterview(
            Interview interview
    );

    Interview findById(
            Long interviewId
    );

}
