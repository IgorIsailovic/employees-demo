package com.igor.homework.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import com.igor.homework.exception.EmployeeNotFoundException;



@ControllerAdvice
public class CustomControllerAdvice {


	@ExceptionHandler(EmployeeNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ResponseBody
	public Error handleEmployeeNotFoundException(EmployeeNotFoundException ex, WebRequest request) {
		return new Error(HttpStatus.NOT_FOUND.value(), ex.getMessage());

	}



}
