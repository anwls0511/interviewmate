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

    private Integer page = 1;

    private Integer size = 10;

    public int getOffset() {
        return (page - 1) * size;
    }
}