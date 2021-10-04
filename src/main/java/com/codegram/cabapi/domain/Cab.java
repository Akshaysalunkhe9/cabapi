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
 * entity for Cap
 * @author Abhijit 
 *
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Cab {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		private String carType;
		private float perKmRate;
		
//		@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
//		@JoinColumn(name = "driverId", nullable = false, updatable = false)
//		@JsonIgnore
//		private Driver driver;
		
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
			this.carType = carType;
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