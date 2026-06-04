package com.interviewmate.admin.usage.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminAiUsageMapper {

    int countTotalRequests();

    int countSuccessRequests();

    int countFailRequests();
}