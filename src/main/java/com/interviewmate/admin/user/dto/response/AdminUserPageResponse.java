package com.interviewmate.admin.user.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class AdminUserPageResponse {

    private int totalCount;

    private int page;

    private int size;

    private List<AdminUserListResponse> users;
}