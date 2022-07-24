package com.cg.onlinepizzaapp.onlinepizzaapp.exception;

@SuppressWarnings("serial")
public class UserNotFoundException extends RuntimeException {
	public UserNotFoundException() {
		super();
	}

	public UserNotFoundException(final String str) {

		super(str);
	}
}