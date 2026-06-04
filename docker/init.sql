CREATE TABLE IF NOT EXISTS users (
                                     user_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                     email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    name VARCHAR(50) NOT NULL,
    role VARCHAR(20) NOT NULL DEFAULT 'USER',
    plan_type VARCHAR(20) NOT NULL DEFAULT 'FREE',
    status VARCHAR(20) NOT NULL DEFAULT 'ACTIVE',
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME NULL
    );

CREATE TABLE IF NOT EXISTS interviews (
                                          interview_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                          user_id BIGINT NOT NULL,
                                          title VARCHAR(100) NOT NULL,
    job_role VARCHAR(50) NOT NULL,
    career_level VARCHAR(50) NOT NULL,
    tech_stack VARCHAR(255) NOT NULL,
    difficulty VARCHAR(20) NOT NULL,
    question_count INT NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'READY',
    score INT NULL,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME NULL
    );

CREATE TABLE IF NOT EXISTS questions (
                                         question_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                         interview_id BIGINT NOT NULL,
                                         question_content TEXT NOT NULL,
                                         question_type VARCHAR(30) NOT NULL DEFAULT 'TECH',
    difficulty VARCHAR(20) NOT NULL,
    sequence INT NOT NULL,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
    );

CREATE TABLE IF NOT EXISTS answers (
                                       answer_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                       interview_id BIGINT NOT NULL,
                                       question_id BIGINT NOT NULL,
                                       user_id BIGINT NOT NULL,
                                       answer_text TEXT NOT NULL,
                                       audio_url VARCHAR(500) NULL,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME NULL
    );

CREATE TABLE IF NOT EXISTS ai_analysis (
                                           analysis_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                           interview_id BIGINT NOT NULL,
                                           answer_id BIGINT NOT NULL,
                                           user_id BIGINT NOT NULL,
                                           professionalism_score INT NOT NULL,
                                           logic_score INT NOT NULL,
                                           communication_score INT NOT NULL,
                                           total_score INT NOT NULL,
                                           feedback TEXT NOT NULL,
                                           improvement_answer TEXT NOT NULL,
                                           status VARCHAR(20) NOT NULL DEFAULT 'COMPLETED',
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME NULL
    );

CREATE TABLE IF NOT EXISTS company_questions (
                                                 company_question_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                                 company_name VARCHAR(100) NOT NULL,
    job_role VARCHAR(50) NOT NULL,
    difficulty VARCHAR(20) NOT NULL,
    question_content TEXT NOT NULL,
    question_type VARCHAR(30) NOT NULL DEFAULT 'TECH',
    is_active CHAR(1) NOT NULL DEFAULT 'Y',
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME NULL
    );

CREATE TABLE IF NOT EXISTS payments (
                                        payment_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                        user_id BIGINT NOT NULL,
                                        plan_type VARCHAR(20) NOT NULL,
    amount INT NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'PAID',
    paid_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
    );

CREATE TABLE IF NOT EXISTS subscriptions (
                                             subscription_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                             user_id BIGINT NOT NULL,
                                             plan_type VARCHAR(20) NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'ACTIVE',
    started_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    expired_at DATETIME NULL,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME NULL
    );

INSERT INTO company_questions
(company_name, job_role, difficulty, question_content, question_type)
VALUES
    ('네이버', 'BACKEND', 'NORMAL', '대용량 트래픽 상황에서 DB 부하를 줄이기 위한 방법을 설명해주세요.', 'TECH'),
    ('카카오', 'BACKEND', 'NORMAL', 'RabbitMQ와 Kafka의 차이를 설명해주세요.', 'TECH'),
    ('토스', 'BACKEND', 'HARD', '결제 시스템에서 트랜잭션 정합성을 보장하는 방법을 설명해주세요.', 'TECH');