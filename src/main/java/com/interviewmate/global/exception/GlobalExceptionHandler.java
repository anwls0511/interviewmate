package com.interviewmate.global.exception;

import com.interviewmate.global.response.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.interviewmate.global.response.ApiResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(
            BusinessException.class
    )
    public ResponseEntity<ErrorResponse>
    handleBusinessException(
            BusinessException e
    ) {

        return ResponseEntity.badRequest()
                .body(
                        new ErrorResponse(
                                false,
                                e.getMessage()
                        )
                );
    }

    @ExceptionHandler(
            Exception.class
    )
    public ResponseEntity<ErrorResponse>
    handleException(
            Exception e
    ) {

        return ResponseEntity.internalServerError()
                .body(
                        new ErrorResponse(
                                false,
                                "서버 오류가 발생했습니다."
                        )
                );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Void>> handleValidationException(
            MethodArgumentNotValidException e
    ) {
        String message = e.getBindingResult()
                .getFieldErrors()
                .get(0)
                .getDefaultMessage();

        return ResponseEntity.badRequest()
                .body(ApiResponse.fail(message));
    }
}