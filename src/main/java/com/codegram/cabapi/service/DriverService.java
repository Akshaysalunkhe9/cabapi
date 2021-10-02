package com.codegram.cabapi.service;

import java.util.List;

import com.codegram.cabapi.domain.Driver;

public interface DriverService {

	/*
	 * This saveOrUpdate will save the driver if id not provided else it will update
	 * @return saved or update driver
	 */
	public Driver saveOrUpdate(Driver driver);
	
	public List<Driver> viewBestDrivers();
	
    public Driver viewDriverDetails(long driverId);
	
	public Driver deleteDriver(long driverId);
	
	
}
