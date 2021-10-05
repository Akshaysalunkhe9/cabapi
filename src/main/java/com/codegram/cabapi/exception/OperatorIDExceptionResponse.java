package com.codegram.cabapi.exception;

public class OperatorIDExceptionResponse {

	public String id;

	public OperatorIDExceptionResponse(String id) {
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