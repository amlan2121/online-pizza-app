package com.cg.onlinepizzaapp.onlinepizzaapp.exception;

@SuppressWarnings("serial")
public class EmptyValuesException extends RuntimeException {
	public EmptyValuesException() {
		super();
	}

	public EmptyValuesException(String str) {
		super(str);
	}
}
