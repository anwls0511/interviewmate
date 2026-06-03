package com.interviewmate.auth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {

    private final StringRedisTemplate redisTemplate;

    private static final String PREFIX = "refreshToken:";

    public void saveRefreshToken(
            Long userId,
            String refreshToken,
            long expiration
    ) {
        redisTemplate.opsForValue().set(
                PREFIX + userId,
                refreshToken,
                Duration.ofMillis(expiration)
        );
    }

    public String getRefreshToken(Long userId) {
        return redisTemplate.opsForValue().get(
                PREFIX + userId
        );
    }

    public void deleteRefreshToken(Long userId) {
        redisTemplate.delete(PREFIX + userId);
    }
}