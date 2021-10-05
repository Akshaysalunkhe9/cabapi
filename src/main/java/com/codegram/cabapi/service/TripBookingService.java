package com.codegram.cabapi.service;

import java.util.List;

import com.codegram.cabapi.domain.TripBooking;

/**
 * This TripBookingService interface will hold the functionality for tripBooking Related Business logic
 * @author Arnav
 *
 */
public interface TripBookingService {
	/**
	 * This insert method will insert the trip booking details of the trip 
	 * @param tripbooking  to be addded provided customerId , CabId,Driver id
	 * @return the Saved tripbooking
	 */
	public TripBooking insertTripBooking(TripBooking tripBooking, int customerId, int cabId, int driverId);
	
	/**
	 * This update method will update the trip booking details of the trip 
	 * @param tripbooking  to beprovided 
	 * @return the Saved/Updated tripbooking
	 */
	public TripBooking updateTripBooking(TripBooking tripBooking);
	/**
	 * This delete method will update the trip booking details of the trip 
	 * @param tripbooking  to beprovided 
	 * @return the Saved/Updated tripbooking
	 */
	public void deleteTripBooking(int tripBookingId);
	/**
	 * This Iterable Method method Show all the trip booking details of the trip 
	 * @param tripbooking  to beprovided 
	 * @return All the tripbooking details
	 */
	public Iterable<TripBooking> findAll();
	/**
	 * This  Method method Show all the trip booking details of the trip with customer id
	 * @param tripbooking  to be provided 
	 * @return All the tripbooking details by the customer id 
	 */
	public List<TripBooking> viewAllTripsCustomer(int customerId);
	
	/**
	 * This  Method method Show all the trip booking details of the trip with customer id
	 * @param tripbooking  to be provided 
	 * @return All the tripbooking details by the customer id 
	 */
	public float calculateTotalBill(int customerId);
	/**
	 * This  Method method Show all the trip booking details of the trip with trip booking id
	 * @param tripbooking  to be provided 
	 * @return All the tripbooking details by the tripBooking id 
	 */
	
	public TripBooking viewTripById(int tripBookingId);

}