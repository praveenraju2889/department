package com.basic.department.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController1 {

	@GetMapping("/")
	public String hello() {
		return "hello hihi";
	}
}
