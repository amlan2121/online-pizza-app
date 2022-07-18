package com.cg.onlinepizzaapp.onlinepizzaapp.exception;

@SuppressWarnings("serial")
public class UserNotFoundException extends RuntimeException {
	public UserNotFoundException() {
	}

	public UserNotFoundException(String str) {

		super(str);
	}
}