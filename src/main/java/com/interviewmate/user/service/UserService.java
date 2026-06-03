package com.interviewmate.user.service;

import com.interviewmate.auth.domain.User;
import com.interviewmate.user.dto.UserResponse;
import com.interviewmate.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;

    public UserResponse getMyInfo(Long userId) {

        User user = userMapper.findById(userId);

        if (user == null) {
            throw new RuntimeException("사용자를 찾을 수 없습니다.");
        }

        return UserResponse.from(user);
    }
}