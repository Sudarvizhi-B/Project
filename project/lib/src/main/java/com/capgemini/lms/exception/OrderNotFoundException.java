package com.capgemini.lms.exception;

public class OrderNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;

	public OrderNotFoundException(String str) {
		super(str);
	}
}
