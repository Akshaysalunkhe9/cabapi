
package com.codegram.cabapi.service;

import java.util.List;

import com.codegram.cabapi.domain.Driver;
import com.codegram.cabapi.domain.TripBooking;

public interface DriverService {

	/*
	 * This saveOrUpdate will save the driver if id not provided else it will update
	 * @return saved or update driver
	 */
	public Driver saveOrUpdate(Driver driver);
	public List<Driver> viewBestDrivers();
    public Driver viewDriverDetails(int driverId);
	public Driver deleteDriver(int driverId);
	public Iterable<Driver> findAll();
	public Driver viewDriverDetailsByEmail(String email);
	
}