package com.aleksandra.validator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

public class ErrorResponse {

	private List<ErrorResource> errors = new ArrayList<>();

	public ErrorResponse(BindingResult bindingResult) {
		Iterator<FieldError> it = bindingResult.getFieldErrors().iterator();
		while (it.hasNext()) {
			FieldError error = it.next();
			ErrorResource resource = new ErrorResource(error.getField(), error.getDefaultMessage());
			errors.add(resource);
		}
	}

	public List<ErrorResource> getErrors() {
		return errors;
	}
	
	public void setErrors(List<ErrorResource> errors) {
		this.errors = errors;
	}

}
