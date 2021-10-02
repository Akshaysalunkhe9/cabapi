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
public class Driver{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	
	@NotBlank(message="Driver identifier is required")
	private String driverIdentifier;
	
	@NotBlank(message="Driver name is required")
	private String driverName;
	
	private float rating;
	
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getDriverIdentifier() {
		return driverIdentifier;
	}
	public void setDriverIdentifier(String driverIdentifier) {
		this.driverIdentifier = driverIdentifier;
	}
	
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}

	public Driver() {
		super();
	}
	
	
}

