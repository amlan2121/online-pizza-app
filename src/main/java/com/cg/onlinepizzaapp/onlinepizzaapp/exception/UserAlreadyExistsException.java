package com.cg.onlinepizzaapp.onlinepizzaapp.exception;

@SuppressWarnings("serial")
public class UserAlreadyExistsException extends RuntimeException {
	public UserAlreadyExistsException() {
	}
	public UserAlreadyExistsException(String str) {
		super(str);
	}

}
