package com.aleksandra.model;

import java.io.Serializable;

public enum GenderType implements Serializable {
	MALE("MALE"), FEMALE("FEMALE");

	String genderType;

	private GenderType(String genderType) {
		this.genderType = genderType;
	}

	public String getGenderType() {
		return genderType;
	} 
	
	public void setGenderType(String genderType) {
		this.genderType = genderType;
	}
}
