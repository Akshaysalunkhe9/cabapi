package com.codegram.cabapi.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * This driver class will be used to register driver
 * @author Animesh
 *
 */
public class Driver{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int driverId;
	private String driverName;
	private float rating;
	
	public Driver(int driverId, String driverName, float rating) {
		super();
		this.driverId = driverId;
		this.driverName = driverName;
		this.rating = rating;
	}
	public int getDriverId() {
		return driverId;
	}
	public void setDriverId(int driverId) {
		this.driverId = driverId;
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
	
	
}