package com.ssafy.pjt_B.mvc.model.dao;

import java.util.List;
import java.util.Map;

import com.ssafy.pjt_B.mvc.model.dto.User;

public interface UserDao {
	public List<User> selectAll();

	public void insertUser(User user);

	public User selectOne(Map<String, String> info);
}
