package com.cg.onlinepizzaapp.onlinepizzaapp.exception;

public class PizzaIdNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public PizzaIdNotFoundException(final String msg) {
		super(msg);
	}

}