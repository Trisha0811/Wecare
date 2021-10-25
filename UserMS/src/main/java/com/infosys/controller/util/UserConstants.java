package com.infosys.controller.util;

public enum UserConstants {

	USERID_NOT_FOUND("userid.not.found");
	private final String type;
	private  UserConstants(String type) {
		this.type = type;
	}
	public String toString() {
		return this.type;
	}
}
