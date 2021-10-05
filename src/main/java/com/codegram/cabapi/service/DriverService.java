package com.codegram.cabapi.service;

import java.util.List;

import javax.validation.Valid;

import com.codegram.cabapi.domain.Driver;

public interface DriverService {

	/**
	 * This view method will save or register the driver and  update details with his id. 
	 * @param driver id will be given
	 * @return driver inserted or update.
	 */
	public Driver saveOrUpdate(Driver driver);
	
	/**
	 * This  method will list the best drivers with ratings>=4.5. 
	 * @param driver will be given
	 * @return driver list who have rating more than 4.5.
	 */
	public List<Driver> viewBestDrivers();
	
	/**
	 * This method will display the driver details with his id. 
	 * @param driver id will be given
	 * @return Driver details
	 */
    public Driver viewDriverDetails(int driverId);
	
    /**
	 * This view method will delete the driver with his id. 
	 * @param driver id will be given
	 * @return driver deleted by the id.
	 */
	public Driver deleteDriver(int driverId);
	
	/**
	 * This view method will display the driver details with his email. 
	 * @param Driver  id will be given
	 * @return driver deleted by the id.
	 */
	public Driver viewDriverDetailsByEmail(String email);

	/**
	 * This view method will display the all driver details . 
	 * 
	 */
	public Iterable<Driver> findAll();
	
}