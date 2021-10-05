package com.codegram.cabapi.domain;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;




/**
 * **
 * This Tripbooking Class is a domain, which represents data and it will be moving
 * layer to layer.
 * @author arnav
 */
@Entity
public class TripBooking {
	

	/**
	 * id of the TripBooking  and  which will be auto generated
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	/**
	 * TripBooking table will have many to one relationship with the customer table
	 */

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "customerId", nullable = false, updatable = false)
	@JsonIgnore
	private Customer customer;
	
	/**
	 * TripBooking table will have many to one relationship with the Cab table
	 */

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "cabId", nullable = false, updatable = false)
	@JsonIgnore
	
	/**
	 * TripBooking table will have many to one relationship with the Driver table
	 */

	private Cab cab;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "driverId", nullable = false, updatable = false)
	@JsonIgnore
	private Driver driver;

	/**
	 * The location from which the trip will be taken
	 */

	@NotBlank(message="From Location is required")
	/**
	 * The location upto which the trip will be delivered 
	 */
	private String fromLocation;
	@NotBlank(message="From Location is required")
	private String toLocation;
	
	/**
	 * Date and time trip taken
	 */
	@JsonFormat(pattern="yyyy-MM-dd HH:mm")
	private LocalDateTime fromDateTime;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm")
	
	/**
	 * Date and time trip taken finished
	 */
	private LocalDateTime toDateTime;
	/**
	 * Trip going on the status will be true and completed then it will be false
	 */
	private boolean status;
	/**
	 * Distance travelled in kilometers
	 */
	private float distanceInKm;
	/**
	 * Billing of the fare
	 */
	private float bill;
	public TripBooking() {
		super();
	}
	
//	public TripBooking(int tripBookingId, Customer customer, Driver driver, String fromLocation, String toLocation,
//			LocalDateTime fromDateTime, LocalDateTime toDateTime, boolean status, float distanceInKm, float bill) {
//		super();
//		this.tripBookingId = tripBookingId;
//		this.customer = customer;
//		this.driver = driver;
//		this.fromLocation = fromLocation;
//		this.toLocation = toLocation;
//		this.fromDateTime = fromDateTime;
//		this.toDateTime = toDateTime;
//		this.status = status;
//		this.distanceInKm = distanceInKm;
//		this.bill = bill;
//	}

	
	public Customer getCustomer() {
		return customer;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getFromLocation() {
		return fromLocation;
	}
	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}
	public String getToLocation() {
		return toLocation;
	}
	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}
	public LocalDateTime getFromDateTime() {
		return fromDateTime;
	}
	public void setFromDateTime(LocalDateTime fromDateTime) {
		this.fromDateTime = fromDateTime;
	}
	public LocalDateTime getToDateTime() {
		return toDateTime;
	}
	public void setToDateTime(LocalDateTime toDateTime) {
		this.toDateTime = toDateTime;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public float getDistanceInKm() {
		return distanceInKm;
	}
	public void setDistanceInKm(float distanceInKm) {
		this.distanceInKm = distanceInKm;
	}
	public float getBill() {
		return bill;
	}
	public void setBill(float bill) {
		this.bill = bill;
	}

	public Cab getCab() {
		return cab;
	}

	public void setCab(Cab cab) {
		this.cab = cab;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	
//	@PrePersist
//	protected void onCreate() {
//		this.fromDateTime = LocalDateTime.now();
//	}
	
}