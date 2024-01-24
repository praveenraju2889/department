package com.basic.department.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.basic.department.entity.ErrorMessge;

@ControllerAdvice
@ResponseStatus
public class RestResponseEnitityExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(DepartmentNotFoundException.class)
	public ResponseEntity<ErrorMessge> departmentNotFoundException(DepartmentNotFoundException exception,
			WebRequest request) {
		
		ErrorMessge messge = new ErrorMessge(HttpStatus.NOT_FOUND,exception.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(messge);
		}
}
