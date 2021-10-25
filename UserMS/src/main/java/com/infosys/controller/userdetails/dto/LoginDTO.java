package com.infosys.controller.userdetails.dto;

import com.infosys.controller.userdetails.entity.UserEntity;

public class LoginDTO {
	
	 String userId;
	 String password;
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
	public LoginDTO(String userId, String password) {
		super();
		this.userId = userId;
		this.password = password;
	}
	public LoginDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	

}
