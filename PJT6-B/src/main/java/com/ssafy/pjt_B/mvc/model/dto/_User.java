package com.ssafy.ssafit.model.dto;

import java.io.Serializable;

public class User implements Serializable{
	
	private static final long serialVersionUID = 10002L;
	private static int no = 1;
	int userSeq;
	String userId;
	String password;
	String userName;
	String nickName;
	
	public User() {}
	
	public User(String userId, String password, String userName, String nickName) {
		this.userSeq = no++;
		this.userId = userId;
		this.password = password;
		this.userName = userName;
		this.nickName = nickName;
	}

	public int getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "User [userSeq=" + userSeq + ", userId=" + userId + ", password=" + password + ", userName=" + userName
				+ ", nickName=" + nickName + "]";
	}

}
