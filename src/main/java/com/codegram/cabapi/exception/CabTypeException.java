package com.codegram.cabapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CabTypeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CabTypeException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CabTypeException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}

}
