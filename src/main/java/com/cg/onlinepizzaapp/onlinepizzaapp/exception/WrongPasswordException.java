package com.cg.onlinepizzaapp.onlinepizzaapp.exception;

@SuppressWarnings("serial")
public class WrongPasswordException extends RuntimeException {
	public WrongPasswordException() {
	}

	public WrongPasswordException(String str) {
		super(str);
	}

}