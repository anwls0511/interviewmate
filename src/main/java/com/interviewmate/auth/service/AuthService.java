package com.interviewmate.auth.service;

import com.interviewmate.auth.domain.User;
import com.interviewmate.auth.dto.request.LoginRequest;
import com.interviewmate.auth.dto.request.RefreshTokenRequest;
import com.interviewmate.auth.dto.request.SignupRequest;
import com.interviewmate.auth.dto.response.LoginResponse;
import com.interviewmate.auth.jwt.JwtProvider;
import com.interviewmate.auth.mapper.AuthMapper;
import com.interviewmate.global.exception.BusinessException;
import com.interviewmate.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthMapper authMapper;

    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    private final RefreshTokenService refreshTokenService;

    public void signup(SignupRequest request) {

        User existsUser = authMapper.findByEmail(request.getEmail());

        if (existsUser != null) {

            throw new BusinessException(ErrorCode.DUPLICATE_EMAIL);

        }

        User user = new User();

        user.setEmail(request.getEmail());

        user.setPassword(passwordEncoder.encode(request.getPassword()));

        user.setName(request.getName());

        user.setRole("USER");

        user.setPlanType("FREE");

        user.setStatus("ACTIVE");

        authMapper.insertUser(user);

    }

    public LoginResponse login(LoginRequest request) {

        User user = authMapper.findByEmail(request.getEmail());

        if (user == null) {
            throw new BusinessException(ErrorCode.USER_NOT_FOUND);
        }

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new BusinessException(ErrorCode.INVALID_PASSWORD);
        }

        String accessToken = jwtProvider.createAccessToken(user);
        String refreshToken = jwtProvider.createRefreshToken(user);

        refreshTokenService.saveRefreshToken(
                user.getUserId(),
                refreshToken,
                jwtProvider.getRefreshTokenExpiration()
        );

        return new LoginResponse(accessToken, refreshToken);
    }

    public LoginResponse refresh(
            RefreshTokenRequest request
    ) {
        String refreshToken = request.getRefreshToken();

        if (!jwtProvider.validateToken(refreshToken)) {
            throw new BusinessException(ErrorCode.INVALID_TOKEN);
        }

        Long userId = jwtProvider.getUserId(refreshToken);

        String savedRefreshToken =
                refreshTokenService.getRefreshToken(userId);

        if (savedRefreshToken == null ||
                !savedRefreshToken.equals(refreshToken)) {
            throw new BusinessException(ErrorCode.INVALID_TOKEN);
        }

        User user = authMapper.findById(userId);

        if (user == null) {
            throw new BusinessException(ErrorCode.USER_NOT_FOUND);
        }

        String newAccessToken =
                jwtProvider.createAccessToken(user);

        String newRefreshToken =
                jwtProvider.createRefreshToken(user);

        refreshTokenService.saveRefreshToken(
                user.getUserId(),
                newRefreshToken,
                jwtProvider.getRefreshTokenExpiration()
        );

        return new LoginResponse(
                newAccessToken,
                newRefreshToken
        );
    }

    public void logout(Long userId) {
        refreshTokenService.deleteRefreshToken(userId);
    }

}