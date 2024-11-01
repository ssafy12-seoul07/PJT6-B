package com.ssafy.pjt_B.mvc.model.dao;

import com.ssafy.pjt_B.mvc.model.dto.User;

public interface UserDao {
	// 이름으로 유저 정보 찾기
	public abstract User findByUserId(String userId);
	
	// 회원가입
	public abstract void saveUser(User user);
}
