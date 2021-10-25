package com.infosys.wecare.Exceptions;

public class ErrorMessage {
	private int errorCode;
    private String message;
//Getters and Setters goes here
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
