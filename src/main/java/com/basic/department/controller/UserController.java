package com.basic.department.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.basic.department.entity.CustomerUser;
import com.basic.department.service.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/registerUser")
    public CustomerUser registUser(@Valid @RequestBody CustomerUser customerUser) throws Exception {
		
		userService.registerUser(customerUser);
		return customerUser;
	}
	
	@PostMapping("/loginUser")
	public CustomerUser customeLogin(@Valid @RequestBody CustomerUser customerUser) throws Exception {
		
		return userService.loginUser(customerUser);
	}

}
