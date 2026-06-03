package com.interviewmate.auth.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class User {

    private Long userId;

    private String email;

    private String password;

    private String name;

    private String role;

    private String planType;

    private String status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}