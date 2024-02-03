package com.basic.department.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController1 {

	@Value("${welcome.message}")
	private String welcomeMessageString;
	@GetMapping("/home")
	public String hello() {
		return welcomeMessageString;
	}
}
