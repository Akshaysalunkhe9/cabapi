package com.codegram.cabapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CustomerIDException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * This will create CustomerIDException object without error message
	 */
	public CustomerIDException() {
		super();
	}

	public CustomerIDException(String msg) {
		super(msg);
	}
}
