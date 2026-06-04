package com.interviewmate.admin.user.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AdminUserStatusResponse {

    private Long userId;

    private String status;
}