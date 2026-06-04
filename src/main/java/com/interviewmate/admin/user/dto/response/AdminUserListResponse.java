package com.interviewmate.admin.user.dto.response;

import com.interviewmate.auth.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class AdminUserListResponse {

    private Long userId;

    private String email;

    private String name;

    private String role;

    private String planType;

    private String status;

    private LocalDateTime createdAt;

    public static AdminUserListResponse from(User user) {
        return new AdminUserListResponse(
                user.getUserId(),
                user.getEmail(),
                user.getName(),
                user.getRole(),
                user.getPlanType(),
                user.getStatus(),
                user.getCreatedAt()
        );
    }
}