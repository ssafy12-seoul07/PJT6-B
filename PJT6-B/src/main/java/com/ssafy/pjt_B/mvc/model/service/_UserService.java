package com.ssafy.ssafit.model.service;

import com.ssafy.ssafit.model.dto.User;

public interface UserService {
	// 로그인
	public abstract User login(String userid, String password);
	
	// 회원가입
	public abstract boolean signup(User user);
}