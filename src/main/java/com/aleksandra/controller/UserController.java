package com.aleksandra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aleksandra.model.User;
import com.aleksandra.service.SecurityService;
import com.aleksandra.service.UserService;
import com.aleksandra.validator.ErrorResource;
import com.aleksandra.validator.UserValidator;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private SecurityService securityService;

	@Autowired
	private UserValidator userValidator;

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
		System.out.println("here");
		//securityService.autologin(user.getUsername(), user.getPassword());
	}

	/*************************************************************************************************************/

	/*@GetMapping("/registration")
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
*/
}
