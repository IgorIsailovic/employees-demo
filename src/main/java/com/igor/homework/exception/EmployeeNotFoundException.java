package com.igor.homework.exception;

public class EmployeeNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String message;

	public EmployeeNotFoundException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
