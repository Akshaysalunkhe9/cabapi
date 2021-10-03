package com.codegram.cabapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CabIDException extends RuntimeException{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CabIDException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CabIDException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}



}