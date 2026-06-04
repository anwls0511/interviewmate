package com.interviewmate.admin.dashboard.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminDashboardMapper {

    int countUsers();

    int countInterviews();

    int countAnalysis();

    int getMonthlyRevenue();
}