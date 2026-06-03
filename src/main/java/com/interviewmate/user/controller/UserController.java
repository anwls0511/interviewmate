package com.interviewmate.user.controller;

import com.interviewmate.global.response.ApiResponse;
import com.interviewmate.user.dto.UserResponse;
import com.interviewmate.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/me")
    public ApiResponse<UserResponse> me(
            Authentication authentication
    ) {
        Long userId = (Long) authentication.getPrincipal();

        UserResponse response = userService.getMyInfo(userId);

        return ApiResponse.success(response);
    }
}