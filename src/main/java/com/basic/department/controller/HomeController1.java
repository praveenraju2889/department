package com.basic.department.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController1 {

	@GetMapping("/home")
	public String hello() {
		return "hello hi";
	}
}
