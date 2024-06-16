package com.example.springtest.exceptions;

public class DuplicateUserNameException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7591911933245371321L;

	public DuplicateUserNameException(String msg) {
		super(msg);
	}
}
