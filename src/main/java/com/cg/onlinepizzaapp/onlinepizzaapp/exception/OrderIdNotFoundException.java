package com.cg.onlinepizzaapp.onlinepizzaapp.exception;

public class OrderIdNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public OrderIdNotFoundException(final String msg) {
		super(msg);
	}

}
