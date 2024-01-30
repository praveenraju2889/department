package com.basic.department.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basic.department.entity.CustomerUser;
import com.basic.department.entity.Department;
import com.basic.department.error.DepartmentNotFoundException;
import com.basic.department.repository.UserRepository;

import jakarta.validation.constraints.Null;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	@Override
	public CustomerUser registerUser(CustomerUser customerUser) throws DepartmentNotFoundException {
		
		 //CustomerUser customerUser = userRepository.findByUserName(customerUser.getUserName());
		
		if(userRepository.findByUserName(customerUser.getUserName()) != null) {
			throw new DepartmentNotFoundException("user already exist");
		}
	  return userRepository.save(customerUser);
		
		 
		
	}
	@Override
	public CustomerUser loginUser(CustomerUser customerUser) throws DepartmentNotFoundException {
		// TODO Auto-generated method stub

		CustomerUser usrdtls = userRepository.findByUserNameAndPassword(customerUser.getUserName(), customerUser.getPassword());
		
		if(usrdtls== null) {
			System.out.println("Username password incorrect or does not exist@@@@@");
			throw new DepartmentNotFoundException("Username password incorrect or does not exist");
		}else {
			System.out.println("Login Successfull");
			return usrdtls;
		}
		
		
	}
	
	

}
