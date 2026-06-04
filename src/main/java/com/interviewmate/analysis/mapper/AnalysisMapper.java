package com.interviewmate.analysis.mapper;

import com.interviewmate.analysis.domain.Analysis;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AnalysisMapper {

    int insertAnalysis(
            Analysis analysis
    );

    Analysis findByInterviewId(
            Long interviewId
    );

}