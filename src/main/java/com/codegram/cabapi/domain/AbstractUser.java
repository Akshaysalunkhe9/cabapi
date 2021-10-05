package com.codegram.cabapi.domain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * **
 * This Abstract User Class is a domain, which represents data and it will be moving
 * layer to layer.
 * 
 */
@MappedSuperclass
public class  AbstractUser {
	
	/**
	 * name of the User
	 */
		
	@NotBlank(message = "Username is Required")
	private String username;
	
	/**
	 * Password of the User
	 */
	
	@NotBlank(message = "Password is required")
	private String password;
	
	/**
	 * Adress of the User
	 */
	private String address;
	
	/**
	 * Mobile number  of the User which should be of 10 digits
	 */
	
	//@NotBlank(message = "provide mobile number")
	@Size(min = 10,max = 10 , message = "Mobile number should be of 10 digits")
	private String mobileNumber;
	
	/**
	 * Mail of the User and it should be unique
	 */
	@NotBlank(message = "Provide an email id")
	@Column(unique = true, updatable = false)
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