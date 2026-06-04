package com.interviewmate.admin.user.controller;

import com.interviewmate.admin.user.dto.request.AdminUserSearchRequest;
import com.interviewmate.admin.user.dto.response.AdminUserListResponse;
import com.interviewmate.admin.user.service.AdminUserService;
import com.interviewmate.global.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/users")
public class AdminUserController {

    private final AdminUserService adminUserService;

    @GetMapping
    public ApiResponse<List<AdminUserListResponse>> getUsers(
            @ModelAttribute AdminUserSearchRequest request
    ) {
        List<AdminUserListResponse> response =
                adminUserService.getUsers(request);

        return ApiResponse.success(response);
    }
}