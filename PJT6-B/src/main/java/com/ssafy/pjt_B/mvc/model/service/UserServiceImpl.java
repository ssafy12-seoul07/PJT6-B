package com.ssafy.pjt_B.mvc.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ssafy.pjt_B.mvc.model.dao.UserDao;
import com.ssafy.pjt_B.mvc.model.dto.User;

@Service
public class UserServiceImpl implements UserService {
	
	private final UserDao userDao;
	
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}

    @Override
    public User login(String userid, String password) {
    	Map<String, String> info = new HashMap<>();
		
		info.put("id", userid);
		info.put("password", password);
		
		User tmp = userDao.selectOne(info);
		
		return tmp;
    }
    
    @Override
	public List<User> getUserList() {
		return userDao.selectAll();
	}

	@Override
	public void signup(User user) {
		userDao.insertUser(user);
	}
}

