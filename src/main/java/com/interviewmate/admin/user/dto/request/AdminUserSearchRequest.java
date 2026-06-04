package com.interviewmate.admin.user.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminUserSearchRequest {

    private String email;

    private String name;

    private String role;

    private String status;

    private String planType;
}