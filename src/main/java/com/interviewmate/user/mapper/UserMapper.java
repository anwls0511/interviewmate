package com.interviewmate.user.mapper;

import com.interviewmate.auth.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User findById(Long userId);

}