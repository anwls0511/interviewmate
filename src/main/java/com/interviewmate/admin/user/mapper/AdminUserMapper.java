package com.interviewmate.admin.user.mapper;

import com.interviewmate.admin.user.dto.request.AdminUserSearchRequest;
import com.interviewmate.auth.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminUserMapper {

    List<User> findUsers(AdminUserSearchRequest request);
}