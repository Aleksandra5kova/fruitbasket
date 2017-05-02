package com.aleksandra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.aleksandra.model.User;
import com.aleksandra.service.SecurityService;
import com.aleksandra.service.UserService;
import com.aleksandra.validator.UserValidator;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private SecurityService securityService;

	@Autowired
	private UserValidator userValidator;

	@GetMapping("/registration")
	public String registrationForm(Model model) {
		model.addAttribute("user", new User());
		return "registration";
	}

	@PostMapping("/registration")
	public String createNewUser(@ModelAttribute User user, BindingResult bindingResult) {

		userValidator.validate(user, bindingResult);

		if (bindingResult.hasErrors()) {
			return "registration";
		} 

		userService.save(user);
		
		securityService.autologin(user.getUsername(), user.getPasswordConfirm());
		
		return "redirect:/welcome";
	}

	@GetMapping("/login")
	public String loginForm() {
		return "login";
	}

	@GetMapping("/welcome")
	public String welcome() {
		return "welcome";
	}

}
