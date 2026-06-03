# InterviewMate

AI 기반 모의면접 플랫폼

면접 준비 과정에서 반복적인 질문 연습과 답변 피드백을 제공하기 위해 개발한 백엔드 프로젝트입니다.

사용자는 면접 유형을 선택하여 모의면접을 진행할 수 있으며, 면접 결과를 기반으로 자신의 답변을 분석하고 개선할 수 있습니다.

---

## 프로젝트 목표

* 실제 면접 환경과 유사한 경험 제공
* 반복 학습을 통한 면접 역량 향상
* AI 기반 질문 생성 및 답변 분석
* 확장 가능한 백엔드 아키텍처 설계

---

## 기술 스택

### Backend

* Java 21
* Spring Boot 3
* Spring Security
* JWT
* MyBatis

### Database

* MariaDB
* Redis

### Infrastructure

* Gradle
* Git
* GitHub

---

## 주요 기능

### 회원 관리

* 회원가입
* 로그인
* 로그아웃
* 내 정보 조회

### 인증 및 보안

* JWT Access Token 인증
* Redis 기반 Refresh Token 관리
* Spring Security 적용

### 면접 기능

* 면접 질문 조회
* 면접 답변 저장
* 면접 결과 조회
* AI 기반 질문 생성

### 사용자 관리

* 면접 이력 관리
* 답변 기록 조회
* 결과 분석 데이터 제공

---

## 프로젝트 구조

```text
src/main/java/com/interviewmate

├── auth
│   ├── controller
│   ├── service
│   ├── mapper
│   ├── dto
│
├── interview
│   ├── controller
│   ├── service
│   ├── mapper
│   ├── dto
│
├── analysis
│
├── answer
│
├── admin
│
└── global
```

---

## ERD

추가 예정

---

## API 문서

추가 예정

---

## 개발 현황

* [x] 회원가입
* [x] 로그인
* [x] JWT 인증
* [x] 사용자 정보 조회
* [ ] Redis Refresh Token
* [ ] 면접 질문 기능
* [ ] 답변 저장 기능
* [ ] AI 질문 생성
* [ ] 결과 분석 기능

---

## 개발자

강무진

Backend Developer
