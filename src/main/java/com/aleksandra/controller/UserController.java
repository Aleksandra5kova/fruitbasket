package com.aleksandra.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aleksandra.model.User;
import com.aleksandra.service.SecurityService;
import com.aleksandra.service.UserService;
import com.aleksandra.validator.ErrorResource;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private SecurityService securityService;

	@GetMapping("/users")
	public List<User> getUsers() {
		return userService.getUsers();
	}

	@PostMapping("/register")
	public List<ErrorResource> saveUser(@RequestBody @Validated User user, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ErrorResource.createErrors(bindingResult);
		}
		userService.save(user);
		return new ArrayList<>();
	}

	@PostMapping("/checkUsername")
	public boolean checkUsername(@RequestBody String username) {
		return (userService.findByUsername(username) == null ? false : true);
	}

	@PostMapping("/checkEmail")
	public boolean checkEmail(@RequestBody String email) {
		return (userService.findByEmail(email) == null ? false : true);
	}
	
	@GetMapping("/isLoggedIn")
	public boolean isLoggedIn(){
		return (securityService.findLoggedInUsername() == null ? false : true);
	}
	
	
	
	@PostMapping("/authenticate")
	public void postloginForm(UsernamePasswordAuthenticationToken token) {
		System.out.println("post login");
	}

	@GetMapping("/authenticate")
	public void loginForm(UsernamePasswordAuthenticationToken token) {
		System.out.println("login");
	}

	@GetMapping("/welcome")
	public void welcome() {
		System.out.println("welcome");
	}

}
