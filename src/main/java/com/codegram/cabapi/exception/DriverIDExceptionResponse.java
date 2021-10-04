package com.codegram.cabapi.exception;

public class DriverIDExceptionResponse {

public String Id;

	
	public DriverIDExceptionResponse(String Id) {
		super();
		this.Id = Id;
	}
	
	public String Id() {
		return Id;
	}

	public void setDriverId(String Id) {
		this.Id = Id;
	}
	
}
