package com.ssafy.pjt_B.mvc.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.pjt_B.mvc.model.dto.User;
import com.ssafy.pjt_B.mvc.model.service.UserService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api-user")
public class UserController {
	private final UserService userService;
	

	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/users")
	public ResponseEntity<?> userList(){
		try {
			List<User> users = userService.getUserList();
			if (users != null && users.size() > 0) {
				return new ResponseEntity<List<User>>(users, HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("sorry: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@PostMapping("/signup")
	public ResponseEntity<?> signup(@RequestBody User user) {
		try {
			userService.signup(user);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User user, HttpSession session) {
		try {
			User authenticatedUser = userService.login(user.getUserId(), user.getPassword());
			if (authenticatedUser != null) {
				session.setAttribute("user", authenticatedUser);
				return new ResponseEntity<User>(authenticatedUser, HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("Invalid credentials", HttpStatus.UNAUTHORIZED);
			}
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	//로그아웃
	@GetMapping("/logout")
	public ResponseEntity<?> logout(HttpSession session) {
		session.invalidate();
		return new ResponseEntity<String>("User logged out successfully", HttpStatus.OK);
	}
}
