package com.codegram.cabapi.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
//import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * This driver class will be used to register driver
 * @author Animesh
 *
 */
@Entity
public class Driver extends AbstractUser{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private float rating;
	private String licenseNumber;
	
	//@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "driver")
	//private List<Cab> cab = new ArrayList<>();
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "driver")
	private List<TripBooking> tripBooking =  new ArrayList<>();
	

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

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public Driver() {
		super();
	}

	public List<TripBooking> getTripBooking() {
		return tripBooking;
	}

	public void setTripBooking(List<TripBooking> tripBooking) {
		this.tripBooking = tripBooking;
	}

//	public List<Cab> getCab() {
//		return cab;
//	}
//
//	public void setCab(List<Cab> cab) {
//		this.cab = cab;
//	}
	

	
	
}