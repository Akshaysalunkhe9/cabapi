package com.codegram.cabapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codegram.cabapi.domain.TripBooking;


/**
 * repository class which will be able to handle the crud operations in the layers of service implementations.
 */
@Repository
public interface TripBookingRepository extends JpaRepository<TripBooking, Integer> {
    TripBooking findById(int id);
 

}