package com.infosys.wecare.util;

public enum CoachConstants {
	COACHID_NOT_FOUND("coachid.not.found");
	private final String type;
	private CoachConstants(String type) {
		this.type = type;
	}
	public String toString() {
		return this.type;
	}
}
