package com.interviewmate.auth.controller;

import com.interviewmate.auth.dto.request.RefreshTokenRequest;
import com.interviewmate.global.response.ApiResponse;
import com.interviewmate.auth.dto.request.LoginRequest;
import com.interviewmate.auth.dto.request.SignupRequest;
import com.interviewmate.auth.dto.response.LoginResponse;
import com.interviewmate.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ApiResponse<Void> signup(@RequestBody SignupRequest request) {
        authService.signup(request);

        return ApiResponse.success("회원가입이 완료되었습니다.", null);
    }

    @PostMapping("/login")
    public ApiResponse<LoginResponse> login(@RequestBody LoginRequest request) {
        LoginResponse response = authService.login(request);

        return ApiResponse.success("로그인이 완료되었습니다.", response);
    }

    @PostMapping("/refresh")
    public ApiResponse<LoginResponse> refresh(@RequestBody RefreshTokenRequest request) {
        LoginResponse response = authService.refresh(request);

        return ApiResponse.success("토큰이 재발급되었습니다.", response);
    }

    @PostMapping("/logout")
    public ApiResponse<Void> logout(Authentication authentication) {
        Long userId = (Long) authentication.getPrincipal();

        authService.logout(userId);

        return ApiResponse.success("로그아웃이 완료되었습니다.", null);
    }
}