package com.ssafy.ssafit.model.repository;

import com.ssafy.ssafit.model.dto.User;

public interface UserRepository {
	// 이름으로 유저 정보 찾기
	public abstract User findByUserId(String userId);
	
	// 회원가입
	public abstract void saveUser(User user);
}
