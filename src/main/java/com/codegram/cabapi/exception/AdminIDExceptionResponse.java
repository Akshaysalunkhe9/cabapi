package com.codegram.cabapi.exception;

public class AdminIDExceptionResponse {

private String adminIdentifier;

	
	public AdminIDExceptionResponse(String adminIdentifier) {
		super();
		this.adminIdentifier = adminIdentifier;
	}
	
	public String getAdminIdentifier() {
		return adminIdentifier;
	}

	public void setAdminIdentifier(String adminIdentifier) {
		this.adminIdentifier = adminIdentifier;
	}
}
	