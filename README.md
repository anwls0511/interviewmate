# InterviewMate

AI 기반 모의면접 플랫폼

## 프로젝트 소개

InterviewMate는 사용자가 원하는 직무와 기술 스택을 선택하여
모의 면접을 진행하고 AI 분석 결과를 제공하는 서비스입니다.

---

## 주요 기능

### 회원

- 회원가입
- 로그인
- JWT 인증
- Refresh Token
- Redis 세션 관리

### 면접

- 면접 생성
- 면접 질문 자동 생성
- 답변 저장
- 면접 종료

### AI 분석

- RabbitMQ 비동기 처리
- 답변 분석
- 피드백 생성
- 점수 산정

### 관리자

- 회원 관리
- 질문 관리
- 결제 관리
- AI 사용량 관리

### 결제

- 요금제 조회
- 구독 생성
- 결제 이력 조회

### 리포트

- PDF 결과 다운로드

---

## 기술 스택

### Backend

- Java 21
- Spring Boot
- Spring Security
- JWT
- MyBatis

### Database

- MariaDB
- Redis

### Message Queue

- RabbitMQ

### Documentation

- Swagger

### AI

- OpenAI API

---

## 시스템 아키텍처

Client
↓
Spring Boot
↓
RabbitMQ
↓
AI Analysis
↓
MariaDB

---

## ERD

(ERD 이미지 추가 예정)

---

## API 문서

http://localhost:8080/swagger-ui/index.html

---

## 실행 방법

### DB

MariaDB 실행

### Redis

6379 포트 실행

### RabbitMQ

15672 관리자 페이지

### Spring Boot

./gradlew bootRun

---

## 작성자

강무진