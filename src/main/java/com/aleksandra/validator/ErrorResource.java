package com.aleksandra.validator;

public class ErrorResource {

	private String fieldName;
	private String defaultMessage;

	public ErrorResource() {
	}

	public ErrorResource(String fieldName, String defaultMessage) {
		super();
		this.fieldName = fieldName;
		this.defaultMessage = defaultMessage;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getDefaultMessage() {
		return defaultMessage;
	}

	public void setDefaultMessage(String defaultMessage) {
		this.defaultMessage = defaultMessage;
	}

	@Override
	public String toString() {
		return "ErrorResource [fieldName=" + fieldName + ", defaultMessage=" + defaultMessage + "]";
	}

}
