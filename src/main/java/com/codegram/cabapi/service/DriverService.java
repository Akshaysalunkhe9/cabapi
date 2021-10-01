package com.codegram.cabapi.service;

import java.util.List;

import com.codegram.cabapi.domain.Driver;

public interface DriverService {
	
	public List<Driver> listAllDriver();
	public Driver viewDriver(int driverId);
	public List<Driver> viewBestDrivers();
	public Driver updateDriver(Driver driver);
	public Driver deleteDriver(int driverId);


}
