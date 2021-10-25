package com.infosys.controller.userdetails.exception;


public class UserIdNotExist extends Exception {
	public UserIdNotExist() {
		super();
	}
	public UserIdNotExist(String error) {
		super(error);
	}
}
