package com.codegram.cabapi.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * **
 * This Customer Class is a domain, which represents data and it will be moving
 * layer to layer.
 * 
 */
@Entity
public class Customer extends AbstractUser {
	
	/**
	 * id of the Customer  and  which will be auto generated
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/**
	 * customer table will have one to many relationship with the trip booking table
	 */
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "customer")
	private List<TripBooking> tripBooking =  new ArrayList<>();

	public Customer() {
		super();
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}





	public List<TripBooking> getTripBooking() {
		return tripBooking;
	}


	public void setTripBooking(List<TripBooking> tripBooking) {
		this.tripBooking = tripBooking;
	}
	
	

}