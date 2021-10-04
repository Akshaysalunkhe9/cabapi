package com.codegram.cabapi.exception;

public class AdminIDExceptionResponse {

	public String id;

	public AdminIDExceptionResponse(String id) {
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