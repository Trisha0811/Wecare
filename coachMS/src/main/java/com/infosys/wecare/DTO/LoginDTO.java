package com.infosys.wecare.DTO;

public class LoginDTO {
 private String coach_id;
 private String password;
 
public LoginDTO() {
	super();
}

public LoginDTO(String coach_id, String password) {
	super();
	this.coach_id = coach_id;
	this.password = password;
}

public String getCoach_id() {
	return coach_id;
}

public void setCoach_id(String coach_id) {
	this.coach_id = coach_id;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

@Override
public String toString() {
	return "LoginDTO [coach_id=" + coach_id + ", password=" + password + "]";
}
 
}
