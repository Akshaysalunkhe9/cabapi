package com.codegram.cabapi.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

/**
 * This driver class will be used to register driver
 * @author Animesh
 *
 */
@Entity
public class Driver extends AbstractUser{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	
	private float rating;
	private long licenseNumber;
	
	public long getId() {
		return Id;
	}

	public void setId(long Id) {
		this.Id = Id;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public long getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(long licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public Driver() {
		super();
	}
}
