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

@Entity
public class Customer extends AbstractUser {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "customer")
	private List<TripBooking> tripBooking =  new ArrayList<>();

	public Customer() {
		super();
	}
	

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}


	public List<TripBooking> getTripBooking() {
		return tripBooking;
	}


	public void setTripBooking(List<TripBooking> tripBooking) {
		this.tripBooking = tripBooking;
	}
	
	

}