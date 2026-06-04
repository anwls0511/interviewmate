package com.interviewmate.admin.user.mapper;

import com.interviewmate.admin.user.dto.request.AdminUserSearchRequest;
import com.interviewmate.auth.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdminUserMapper {

    List<User> findUsers(AdminUserSearchRequest request);

    int updateUserStatus(@Param("userId") Long userId,
                         @Param("status") String status);
}