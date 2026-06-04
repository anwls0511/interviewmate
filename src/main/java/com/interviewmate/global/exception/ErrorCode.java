package com.interviewmate.global.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    USER_NOT_FOUND(
            "사용자를 찾을 수 없습니다."
    ),

    INVALID_PASSWORD(
            "비밀번호가 일치하지 않습니다."
    ),

    DUPLICATE_EMAIL(
            "이미 가입된 이메일입니다."
    ),

    INVALID_TOKEN(
            "유효하지 않은 토큰입니다."
    ),

    ANALYSIS_NOT_FOUND(
            "분석 결과를 찾을 수 없습니다."
    ),

    INTERNAL_SERVER_ERROR(
            "서버 오류가 발생했습니다."
    );

    private final String message;
}