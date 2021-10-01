package com.codegram.cabapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codegram.cabapi.domain.TripBooking;


/**
 * @author Arnav
 *
 */
@Repository
public interface TripBookingRepository extends CrudRepository<TripBooking, Integer> {
	//TripBooking findBytripBookingId(Integer tripBookingId);

}
