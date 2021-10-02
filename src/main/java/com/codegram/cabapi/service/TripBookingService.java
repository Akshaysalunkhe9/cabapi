package com.codegram.cabapi.service;

import java.util.List;

import com.codegram.cabapi.domain.TripBooking;



/**
 * @author Arnav
 *
 */
public interface TripBookingService {
	public TripBooking insertTripBooking(TripBooking tripBooking, Long customerId);
	public TripBooking updateTripBooking(TripBooking tripBooking);
	public Iterable<TripBooking> deleteTripBooking(int tripBookingId);
	public Iterable<TripBooking> findAll();
	public List<TripBooking> viewAllTripsCustomer(int customerId);
	public float calculateBill(int customerId);
	public TripBooking viewTripById(int tripBookingId);

}
