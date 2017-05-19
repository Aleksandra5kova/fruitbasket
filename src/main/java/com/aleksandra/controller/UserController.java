package com.aleksandra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aleksandra.model.User;
import com.aleksandra.service.UserService;
import com.aleksandra.validator.ErrorResource;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	@ResponseBody
	public List<User> getUsers() {
		return userService.getUsers();
	}

	@PostMapping("/users")
	public List<ErrorResource> saveUser(@RequestBody @Validated User user, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ErrorResource.createErrors(bindingResult);
		}
		userService.save(user);
		// securityService.autologin(user.getUsername(),
		// user.getPasswordConfirm());
		return null;
	}

	@PostMapping("/checkUsername")
	public boolean checkUsername(@RequestBody String username) {
		return (userService.findByUsername(username) == null ? false : true);
	}

	@PostMapping("/checkEmail")
	public boolean checkEmail(@RequestBody String email) {
		return (userService.findByEmail(email) == null ? false : true);
	}

	@PostMapping("/authenticate")
	public void loginUser(UsernamePasswordAuthenticationToken token) {
		System.out.println("post here");
	}

	@GetMapping("/authenticate")
	public void getloginUser(UsernamePasswordAuthenticationToken token) {
		System.out.println("get here");
	}

	@GetMapping("/login")
	public void loginForm(UsernamePasswordAuthenticationToken token) {
		System.out.println("login");
	}

	@PostMapping("/login")
	public void postloginForm(UsernamePasswordAuthenticationToken token) {
		System.out.println("post login");
	}

	@GetMapping("/welcome")
	public void welcome() {
		System.out.println("welcome");
	}

}
