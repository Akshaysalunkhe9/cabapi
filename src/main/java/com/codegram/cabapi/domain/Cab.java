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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * 
 * This Project Class is a domain, which represents data and it will be moving
 * layer to layer.
 * 
 * entity for Cap
 * @author Abhijit 
 *
 *
 *
 *
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Cab {

		/**
		 * id of the Cab  and auto generated
		 */
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		
		/**
		 * carType of the Cab
		 */
		private String carType;
		
		/**
		 * rate per km of the Cab
		 */
		private float perKmRate;
		
//		@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
//		@JoinColumn(name = "driverId", nullable = false, updatable = false)
//		@JsonIgnore
//		private Driver driver;
		
		
		//One to Many between Tripbooking and Cab
		@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "cab")
		private List<TripBooking> tripBooking =  new ArrayList<>();
		
		public Cab() {
			super();
		}
		
		/*public Cab(int cabId, String carType, float perKmRate) {
			super();
			this.cabId = cabId;
			this.carType = carType;
			this.perKmRate = perKmRate;
		}*/

		

		public String getCarType() {
			return carType;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public void setCarType(String carType) {
			this.carType = carType.toUpperCase();
		}

		public float getPerKmRate() {
			return perKmRate;
		}

		public void setPerKmRate(float perKmRate) {
			this.perKmRate = perKmRate;
		}

//		public Driver getDriver() {
//			return driver;
//		}
//
//		public void setDriver(Driver driver) {
//			this.driver = driver;
//		}

		public List<TripBooking> getTripBooking() {
			return tripBooking;
		}

		public void setTripBooking(List<TripBooking> tripBooking) {
			this.tripBooking = tripBooking;
		}
		
		
		
}