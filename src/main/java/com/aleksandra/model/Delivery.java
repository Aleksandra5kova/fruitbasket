package com.aleksandra.model;

public enum Delivery {
	YES("YES"), NO("NO");
	
	String delivery;

	private Delivery(String delivery) {
		this.delivery = delivery;
	}
	
	public String getDelivery() {
		return delivery;
	}
	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}
}
