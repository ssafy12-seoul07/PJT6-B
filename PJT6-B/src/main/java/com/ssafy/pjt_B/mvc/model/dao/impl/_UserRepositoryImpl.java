package com.ssafy.ssafit.model.repository.impl;

import java.util.ArrayList;
import java.util.List;
import com.ssafy.ssafit.model.dto.User;
import com.ssafy.ssafit.model.repository.UserRepository;

public class UserRepositoryImpl implements UserRepository{

    // 사용자 데이터를 저장할 리스트
    private List<User> users = new ArrayList<>();
    
    private UserRepositoryImpl() {
        users.add(new User("ssafy1@gmail.com", "password", "은서", "YES"));
        users.add(new User("ssafy2@ssafy.com", "password", "유영", "SU0"));
        users.add(new User("ssafy3@naver.com", "password", "희주", "KPT"));
    }
    
    private static UserRepository repo = new UserRepositoryImpl();
    
    public static UserRepository getInstance() {
        return repo;
    }

    // userId로 사용자를 검색하는 메서드
    @Override
    public User findByUserId(String userId) {
        for (User user : users) {
            if (user != null && user.getUserId().equals(userId)) {
                return user;
            }
        }
        return null; 
    }


    // 새로운 사용자를 저장하는 메서드
    @Override
    public void saveUser(User user) {
//    	System.out.println("Saving user: " + user.getUserId());
        users.add(user);
//        System.out.println("Total users after save: " + users.size());
    }

}
