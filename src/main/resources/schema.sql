-- =============================================
-- PostgreSQL 테이블 자동 생성 스크립트
-- DataSourceInitializer가 서버 시작 시 실행
-- =============================================

-- users 테이블 (없으면 생성, 있으면 건드리지 않음)
CREATE TABLE IF NOT EXISTS users (
    id       SERIAL PRIMARY KEY,
    name     VARCHAR(50)  NOT NULL,
    email    VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

-- 테스트 데이터 (중복 무시)
INSERT INTO users (name, email, password)
SELECT '홍길동', 'hong@test.com', '1234'
WHERE NOT EXISTS (SELECT 1 FROM users WHERE email = 'hong@test.com');

INSERT INTO users (name, email, password)
SELECT '김철수', 'kim@test.com', '1234'
WHERE NOT EXISTS (SELECT 1 FROM users WHERE email = 'kim@test.com');
