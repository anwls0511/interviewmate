package com.interviewmate.dashboard.mapper;

import com.interviewmate.interview.domain.Interview;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DashboardMapper {

    int countByUserId(Long userId);

    Integer averageScoreByUserId(Long userId);

    List<Interview> findRecentByUserId(Long userId);
}