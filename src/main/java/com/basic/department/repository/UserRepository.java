package com.basic.department.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.basic.department.entity.CustomerUser;


@Repository
public interface UserRepository extends JpaRepository<CustomerUser, Long>{

	public CustomerUser findByUserNameAndPassword(String userName,String password);
	public CustomerUser findByUserName(String userName);
}
