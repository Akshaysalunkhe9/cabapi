package com.codegram.cabapi.exception;

public class CustomerIDExceptionResponse {

	public String id;

	public CustomerIDExceptionResponse(String id) {
		super();
		this.id = id;
	}

	public String id() {
		return id;
	}

	public void setCustomerId(String id) {
		this.id = id;
	}
	
	
}