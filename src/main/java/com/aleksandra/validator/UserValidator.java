package com.aleksandra.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.aleksandra.model.User;
import com.aleksandra.service.UserService;

@Component
public class UserValidator implements Validator {

	@Autowired
	private UserService userService;

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		User user = (User) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty", "Email is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty", "Username is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty", "Password is required.");

		if (user.getUsername() != null && user.getPassword() != null && user.getEmail() != null) {

			if (userService.findByEmail(user.getEmail()) != null) {
				errors.rejectValue("email", "DuplicateEmail", "Email must be unique.");
			}

			if (userService.findByUsername(user.getUsername()) != null) {
				errors.rejectValue("username", "DuplicateUsername", "Username must be unique.");
			}

			if (user.getUsername().length() < 6 && user.getUsername().length() > 32) {
				errors.rejectValue("username", "SizeUusername", "Username must be between 6-32 characters long.");
			}

			if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
				errors.rejectValue("password", "SizePassword", "Password must be between 8-32 characters long.");
			}

		}
	}

}
