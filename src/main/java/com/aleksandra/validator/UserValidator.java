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

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwordConfirm", "NotEmpty", "NotEmpty");

		if (user.getUsername() != null && user.getPassword() != null && user.getPasswordConfirm() != null
				&& user.getEmail() != null) {

			if (user.getUsername().length() < 6 && user.getUsername().length() > 32) {
				errors.rejectValue("username", "SizeUusername", "SizeUusername");
			}

			if (userService.findByUsername(user.getUsername()) != null) {
				errors.rejectValue("username", "DuplicateUsername", "DuplicateUsername");
			}

			if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
				errors.rejectValue("password", "SizePassword", "SizePassword");
			}

			if (!user.getPasswordConfirm().equals(user.getPassword())) {
				errors.rejectValue("passwordConfirm", "DiffPasswordConfirm", "DiffPasswordConfirm");
			}
		}
	}

}
