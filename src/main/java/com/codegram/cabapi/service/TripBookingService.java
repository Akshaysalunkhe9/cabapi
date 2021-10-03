package com.codegram.cabapi.service;

import java.util.List;

import com.codegram.cabapi.domain.TripBooking;



/**
 * @author Arnav
 *
 */
public interface TripBookingService {
	public TripBooking insertTripBooking(TripBooking tripBooking, int customerId, int cabId, int driverId);
	public TripBooking updateTripBooking(TripBooking tripBooking);
	public Iterable<TripBooking> deleteTripBooking(int tripBookingId);
	public Iterable<TripBooking> findAll();
	public List<TripBooking> viewAllTripsCustomer(int customerId);
	public float calculateTotalBill(int customerId);
	public TripBooking viewTripById(int tripBookingId);

}
