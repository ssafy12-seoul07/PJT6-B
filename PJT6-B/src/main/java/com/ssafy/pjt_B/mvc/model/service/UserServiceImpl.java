package com.ssafy.pjt_B.mvc.model.service;

import com.ssafy.pjt_B.mvc.model.dao.UserDao;
import com.ssafy.pjt_B.mvc.model.dto.User;

public class UserServiceImpl implements UserService {
	
	private final UserDao userDao;
	
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}

    @Override
    public User login(String userid, String password) {
        User user = userDao.findByUserId(userid);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    @Override
    public boolean signup(User user) {
        if (userDao.findByUserId(user.getUserId()) != null) {
            return false;  // 이미 존재하는 사용자
        }
        userDao.saveUser(user);
        // 저장 직후 다시 한번 확인
//        if (repo.findByUserId(user.getUserId()) != null) {
//            System.out.println("User saved successfully!");
//        } else {
//            System.out.println("Failed to find user after saving.");
//        }

        return true;
    }
}

