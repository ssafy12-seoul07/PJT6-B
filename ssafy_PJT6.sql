drop database if exists ssafy_PJT6;
create database pjt6;
use pjt6;

-- 1. 회원 테이블 생성
CREATE TABLE User (
    id INT PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(100) NOT NULL UNIQUE,	-- 아이디 대용? 
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL
);

-- 2. 운동 부위 테이블 생성
CREATE TABLE Category (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL UNIQUE
);

-- 3. 운동 영상 테이블 생성
CREATE TABLE Video (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    views INT DEFAULT 0,
    category_id INT,
    FOREIGN KEY (category_id) REFERENCES Category(id) ON DELETE SET NULL
);

-- 4. 리뷰 테이블 생성
CREATE TABLE Review (
    id INT PRIMARY KEY AUTO_INCREMENT,
    video_id INT NOT NULL,
    user_id INT NOT NULL,
    content TEXT,
    FOREIGN KEY (video_id) REFERENCES Video(id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES User(id) ON DELETE CASCADE
);

-- 5. 찜 관리 테이블 생성
CREATE TABLE Favorites (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    video_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES User(id) ON DELETE CASCADE,
    FOREIGN KEY (video_id) REFERENCES Video(id) ON DELETE CASCADE,
    UNIQUE (user_id, video_id)  -- 동일한 회원이 같은 영상을 여러 번 찜하지 않도록 설정
);

-- select * from User;