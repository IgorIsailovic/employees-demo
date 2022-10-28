package com.igor.homework.error;

public class Error {

	private int httpCode;
	private String message;

	public int getHttpCode() {
		return httpCode;
	}

	public void setHttpCode(int httpCode) {
		this.httpCode = httpCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Error(int httpCode, String message) {
		this.httpCode = httpCode;
		this.message = message;
	}

	public Error() {
	}

	@Override
	public String toString() {
		return "ErrorResponse [httpCode=" + httpCode + ", message=" + message + "]";
	}

}
