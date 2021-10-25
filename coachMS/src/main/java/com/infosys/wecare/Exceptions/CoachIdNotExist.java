package com.infosys.wecare.Exceptions;

public class CoachIdNotExist extends Exception {
	public CoachIdNotExist() {
		super();
	}
	public CoachIdNotExist(String error) {
		super(error);
	}
}
