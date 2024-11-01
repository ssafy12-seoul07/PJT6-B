package com.ssafy.pjt_B.mvc.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.pjt_B.mvc.model.dto.User;

@Service
public interface UserService {
	// 로그인
	public abstract User login(String userid, String password);
	
	// 회원가입
	public abstract void signup(User user);
	
	//전체 사용자 목록 불러오기
	public List<User> getUserList();
}