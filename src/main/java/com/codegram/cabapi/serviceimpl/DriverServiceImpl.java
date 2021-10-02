package com.codegram.cabapi.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codegram.cabapi.domain.Driver;
import com.codegram.cabapi.exception.DriverIDException;
import com.codegram.cabapi.repository.DriverRepository;
import com.codegram.cabapi.service.DriverService;

@Service
public class DriverServiceImpl implements DriverService {

	@Autowired
	private DriverRepository driverRepository; 
	
	@Override
	public Driver saveOrUpdate(Driver driver) {
		try {
			driver.setDriverIdentifier(driver.getDriverIdentifier().toLowerCase());
			return driverRepository.save(driver);
		}
		catch(Exception e)
		{
			throw new DriverIDException("Driver ID"+driver.getDriverIdentifier().toUpperCase()+" already exists");
		}
	}

	@Override
	public Driver findDriverByDriverIdentifier(String driverId) {
		Driver driver = driverRepository.findByDriverIdentifier(driverId);
		if(driver==null)
		{
			throw new DriverIDException("Driver id"+driverId+" does not exists");
		}
		return driver;
	}

	@Override
	public List<Driver> viewBestDrivers() {
		List<Driver> allDrivers=new ArrayList<>();
		allDrivers=driverRepository.findAll();
		List<Driver> bestDrivers=allDrivers.stream().filter(d->d.getRating()>4.5).collect(Collectors.toList());
		return bestDrivers;
	}

	@Override
	public Driver deleteDriver(String driverId) {
		Driver driver=findDriverByDriverIdentifier(driverId);
		driverRepository.delete(driver);
		return driver;
	}
}
