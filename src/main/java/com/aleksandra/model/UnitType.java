package com.aleksandra.model;

import java.io.Serializable;

public enum UnitType implements Serializable {
	gram("g"), kilogram("kg");

	String unitType;

	private UnitType(String unitType) {
		this.unitType = unitType;
	}

	public String getUnitType() {
		return unitType;
	}

	public void setUnitType(String unitType) {
		this.unitType = unitType;
	}

}
