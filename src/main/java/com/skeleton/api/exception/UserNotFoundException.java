package com.skeleton.api.exception;

public class UserNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String errorMessage, Throwable err) {
		super(errorMessage, err);
	}
}
