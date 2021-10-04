package com.codegram.cabapi.exception;

public class DriverIDExceptionResponse {

private String driverIdentifier;

	
	public DriverIDExceptionResponse(String driverIdentifier) {
		super();
		this.driverIdentifier = driverIdentifier;
	}
	
	public String getDriverIdentifier() {
		return driverIdentifier;
	}

	public void setDriverIdentifier(String driverIdentifier) {
		this.driverIdentifier = driverIdentifier;
	}
	
}