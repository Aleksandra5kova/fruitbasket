package com.aleksandra.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {

	@GetMapping("companies")
	public String helloWorld() {
		return "Hello world";
	}
}
