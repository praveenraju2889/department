package com.basic.department.service;

import com.basic.department.entity.CustomerUser;

public interface UserService {
	
	public CustomerUser registerUser(CustomerUser customerUser) throws Exception;

	public CustomerUser loginUser(CustomerUser customerUser) throws Exception;


}
