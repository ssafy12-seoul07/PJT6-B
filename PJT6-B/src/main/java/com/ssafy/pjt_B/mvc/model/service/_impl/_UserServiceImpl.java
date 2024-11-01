package com.ssafy.ssafit.model.service.impl;

import com.ssafy.ssafit.model.dto.User;
import com.ssafy.ssafit.model.repository.UserRepository;
import com.ssafy.ssafit.model.repository.impl.UserRepositoryImpl;
import com.ssafy.ssafit.model.service.UserService;

public class UserServiceImpl implements UserService {
	
	private UserRepository repo = UserRepositoryImpl.getInstance(); // Singleton 인스턴스 가져오기
    
	private UserServiceImpl() {}
	
    private static UserService service = new UserServiceImpl();

    public static UserService getInstance() {
        return service;
    }

    @Override
    public User login(String userid, String password) {
        User user = repo.findByUserId(userid);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    @Override
    public boolean signup(User user) {
        if (repo.findByUserId(user.getUserId()) != null) {
            return false;  // 이미 존재하는 사용자
        }
        repo.saveUser(user);
        // 저장 직후 다시 한번 확인
//        if (repo.findByUserId(user.getUserId()) != null) {
//            System.out.println("User saved successfully!");
//        } else {
//            System.out.println("Failed to find user after saving.");
//        }

        return true;
    }

}

