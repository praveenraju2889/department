package com.basic.department;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DepartmentApplication {

	public static void main(String[] args) {
		System.out.println("Started dept init");
		SpringApplication.run(DepartmentApplication.class, args);
		System.out.println("Started dept end");
	}

}
