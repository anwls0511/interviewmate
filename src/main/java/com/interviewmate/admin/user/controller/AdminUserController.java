package com.interviewmate.admin.user.controller;

import com.interviewmate.admin.user.dto.request.AdminUserSearchRequest;
import com.interviewmate.admin.user.dto.request.AdminUserStatusUpdateRequest;
import com.interviewmate.admin.user.dto.response.AdminUserListResponse;
import com.interviewmate.admin.user.dto.response.AdminUserStatusResponse;
import com.interviewmate.admin.user.service.AdminUserService;
import com.interviewmate.global.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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