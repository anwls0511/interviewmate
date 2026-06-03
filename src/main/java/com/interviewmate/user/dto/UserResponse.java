package com.interviewmate.user.dto;

import com.interviewmate.auth.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserResponse {

    private Long userId;
    private String email;
    private String name;
    private String role;
    private String planType;
    private String status;

    public static UserResponse from(User user) {
        return new UserResponse(
                user.getUserId(),
                user.getEmail(),
                user.getName(),
                user.getRole(),
                user.getPlanType(),
                user.getStatus()
        );
    }
}