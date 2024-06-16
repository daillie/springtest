package com.example.springtest.exceptions;

import java.util.NoSuchElementException;

public class UserNotFoundException extends NoSuchElementException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -444711892881888779L;

	public UserNotFoundException(String msg) {
		super(msg);
	}
}
