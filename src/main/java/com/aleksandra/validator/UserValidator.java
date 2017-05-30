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

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "emailRequiered", "emailRequiered");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "usernameRequiered", "usernameRequiered");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "passwordRequiered", "passwordRequiered");

		if (user.getUsername() != null && user.getPassword() != null && user.getEmail() != null) {

			if (userService.findByEmail(user.getEmail()) != null) {
				errors.rejectValue("email", "emailExist", "emailExist");
			}

			if (userService.findByUsername(user.getUsername()) != null) {
				errors.rejectValue("username", "usernameExist", "usernameExist");
			}

			if (user.getUsername().length() < 6 && user.getUsername().length() > 32) {
				errors.rejectValue("username", "usernameSize", "usernameSize");
			}

			if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
				errors.rejectValue("password", "passwordSize", "passwordSize");
			}

		}
	}

}
