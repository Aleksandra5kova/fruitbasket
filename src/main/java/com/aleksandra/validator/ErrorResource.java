package com.aleksandra.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

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

	public static List<ErrorResource> createErrors(BindingResult bindingResult) {
		List<ErrorResource> errors = new ArrayList<>();
		for (FieldError error : bindingResult.getFieldErrors()) {
			ErrorResource resource = new ErrorResource(error.getField(), error.getDefaultMessage());
			errors.add(resource);
		}
		return errors;
	}

}
