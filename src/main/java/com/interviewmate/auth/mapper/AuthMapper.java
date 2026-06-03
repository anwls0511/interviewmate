package com.interviewmate.auth.mapper;

import com.interviewmate.auth.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthMapper {

    User findByEmail(String email);

    int insertUser(User user);

    User findById(Long userId);
}