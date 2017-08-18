package com.aleksandra.configuration.rabbitmq;

public class Notification {

	private String type;
	private String message;

	public Notification() {

	}

	public Notification(String type, String message) {
		this.type = type;
		this.message = message;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Notification [type=" + type + ", message=" + message + "]";
	}

}
