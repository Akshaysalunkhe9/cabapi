package com.codegram.cabapi.domain;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@MappedSuperclass
public class  AbstractUser {
	
	@NotBlank(message = "Username is Required")
	private String username;
	
	@NotBlank(message = "Password is required")
	private String password;
	
	private String address;
	
	@NotBlank(message = "provide mobile number")
	@Size(min = 10,max = 10 , message = "Mobile number should be of 10 digits")
	private String mobileNumber;
	
	@NotBlank(message = "Provide an email id")
	private String email;
	
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
}