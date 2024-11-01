drop database if exists ssafy_PJT6;
create database ssafy_PJT6;
use ssafy_PJT6;

-- 1. 회원 테이블 생성
CREATE TABLE User (
    user_seq INT PRIMARY KEY AUTO_INCREMENT,
    user_id VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    user_name VARCHAR(50) NOT NULL UNIQUE,
    nick_name VARCHAR(50) NOT NULL UNIQUE
);

-- 2. 운동 부위 테이블 생성
-- CREATE TABLE Category (
--     id INT PRIMARY KEY AUTO_INCREMENT,
--     name VARCHAR(50) NOT NULL UNIQUE
-- );

-- 3. 운동 영상 테이블 생성
CREATE TABLE Video (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    discription TEXT NOT NULL,
    body_part VARCHAR(50),
    views INT DEFAULT 0
);

-- 4. 리뷰 테이블 생성
CREATE TABLE Review (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title varchar(100) not null,
    writer varchar(50) not null,
    content TEXT,
    regDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- 회원(User) 더미 데이터 삽입Ni
INSERT INTO User (user_id, password, user_name, nick_name) VALUES
('user1', 'password123', 'user1', '닉네임1'),
('user2', 'password456', 'user2', '닉네임2'),
('user3', 'password789', 'user3', '닉네임3'),
('user4', 'password101', 'user4', '닉네임4'),
('user5', 'password202', 'user5', '닉네임5');

-- 운동 영상(Video) 더미 데이터 삽입
INSERT INTO Video (title, discription, body_part, views) VALUES
('Yoga for Beginners', 'Beginner yoga video for full body flexibility', 'full body', 1500),
('Core Strengthening', 'Exercises to strengthen your core', 'core', 3000),
('Leg Day Workout', 'Leg workout routine', 'legs', 2000),
('Upper Body Workout', 'Workout for upper body strength', 'upper body', 4000),
('Cardio Blast', 'High-intensity cardio workout', 'cardio', 3500);

-- 리뷰(Review) 더미 데이터 삽입
INSERT INTO Review (title, writer, content) VALUES
('Great Yoga Routine', 'user1', 'This yoga routine really helps me relax and stretch out.'),
('Intense Core Workout', 'user2', 'The core exercises are challenging but effective.'),
('Leg Workout', 'user3', 'Good exercises to tone and strengthen legs.'),
('Upper Body Strength', 'user4', 'Great for building upper body strength!'),
('Cardio Session', 'user5', 'This cardio routine makes me sweat every time!');

-- select * from Review;