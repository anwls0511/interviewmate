# InterviewMate Project Structure

## Project Overview

AI 기반 모의면접 플랫폼

### Tech Stack

* Java 21
* Spring Boot 3.x
* Spring Security
* JWT
* MyBatis
* MariaDB
* Redis
* RabbitMQ
* OpenAI API
* Gradle

---

# Backend Architecture

```text
Controller
    ↓
Service
    ↓
Mapper(MyBatis)
    ↓
MariaDB
```

---

# Domain Structure

```text
com.interviewmate

├─ global
├─ auth
├─ user
├─ interview
├─ question
├─ answer
├─ analysis
├─ companyquestion
├─ resume
├─ payment
├─ subscription
└─ admin
```

---

# Global Package

```text
global
├─ config
├─ exception
├─ response
├─ security
└─ util
```

---

# Auth Domain

```text
auth
├─ controller
├─ service
├─ dto
│   ├─ request
│   └─ response
├─ mapper
└─ domain
```

### APIs

* 회원가입
* 로그인
* 로그아웃
* 토큰 재발급

---

# User Domain

```text
user
├─ controller
├─ service
├─ dto
├─ mapper
└─ domain
```

### APIs

* 내 정보 조회
* 프로필 수정
* 구독 상태 조회

---

# Interview Domain

```text
interview
├─ controller
├─ service
├─ dto
├─ mapper
└─ domain
```

### APIs

* 면접 생성
* 면접 조회
* 면접 종료
* 면접 이력 조회

---

# Question Domain

```text
question
├─ controller
├─ service
├─ dto
├─ mapper
└─ domain
```

### APIs

* 질문 생성
* 질문 조회
* 기업별 질문 조회

---

# Answer Domain

```text
answer
├─ controller
├─ service
├─ dto
├─ mapper
└─ domain
```

### APIs

* 답변 저장
* 답변 조회

---

# Analysis Domain

```text
analysis
├─ controller
├─ service
├─ dto
├─ mapper
├─ domain
├─ producer
├─ consumer
└─ openai
```

### APIs

* AI 분석 요청
* 분석 상태 조회
* 분석 결과 조회

### Infrastructure

* RabbitMQ
* Redis
* OpenAI

---

# Payment Domain

```text
payment
├─ controller
├─ service
├─ dto
├─ mapper
└─ domain
```

### APIs

* 구독 결제
* 결제 이력 조회
* 구독 취소

---

# Admin Domain

```text
admin
├─ dashboard
├─ user
├─ question
├─ payment
└─ usage
```

### APIs

* 관리자 대시보드
* 회원 관리
* 질문 관리
* 결제 관리
* AI 사용량 관리

---

# Development Order

1. auth
2. user
3. interview
4. question
5. answer
6. analysis
7. payment
8. admin

---

# Mapper XML Location

```text
src/main/resources/mapper
```

Example:

```text
mapper
├─ auth
│   └─ AuthMapper.xml
├─ user
│   └─ UserMapper.xml
├─ interview
│   └─ InterviewMapper.xml
```

---

# Naming Convention

Controller

* AuthController
* UserController
* InterviewController

Service

* AuthService
* UserService
* InterviewService

Mapper

* AuthMapper
* UserMapper
* InterviewMapper

DTO

* LoginRequest
* LoginResponse
* SignupRequest
* SignupResponse

```
```
