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

	/**
	 * Id of project and its auto generated
	 *
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/**
	 * Ratings for driver
	 */
	private float rating;
	
	/**
	 * License number of driver
	 */
	private long licenseNumber;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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