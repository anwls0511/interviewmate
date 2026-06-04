package com.interviewmate.admin.user.controller;

import com.interviewmate.admin.user.dto.request.AdminUserSearchRequest;
import com.interviewmate.admin.user.dto.request.AdminUserStatusUpdateRequest;
import com.interviewmate.admin.user.dto.response.AdminUserPageResponse;
import com.interviewmate.admin.user.dto.response.AdminUserStatusResponse;
import com.interviewmate.admin.user.service.AdminUserService;
import com.interviewmate.global.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/users")
public class AdminUserController {

    private final AdminUserService adminUserService;

    @GetMapping
    public ApiResponse<AdminUserPageResponse> getUsers(
            @ModelAttribute AdminUserSearchRequest request
    ) {
        AdminUserPageResponse response =
                adminUserService.getUsers(request);

        return ApiResponse.success(response);
    }

    @PatchMapping("/{userId}/status")
    public ApiResponse<AdminUserStatusResponse> updateUserStatus(
            @PathVariable Long userId,
            @RequestBody AdminUserStatusUpdateRequest request
    ) {
        AdminUserStatusResponse response =
                adminUserService.updateUserStatus(
                        userId,
                        request
                );

        return ApiResponse.success(
                "회원 상태가 변경되었습니다.",
                response
        );
    }
}