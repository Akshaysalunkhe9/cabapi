package com.codegram.cabapi.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TripBookingIDException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public TripBookingIDException() {}
	
	public TripBookingIDException(String msg) {
		super(msg);
	}

}