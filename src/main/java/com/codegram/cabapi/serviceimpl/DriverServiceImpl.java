package com.codegram.cabapi.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.codegram.cabapi.exception.*;
import com.codegram.cabapi.domain.Driver;
import com.codegram.cabapi.repository.DriverRepository;
import com.codegram.cabapi.service.DriverService;


@Service
public class DriverServiceImpl implements DriverService {

	@Autowired
	private DriverRepository driverRepository; 
	
	@Override
	public Driver saveOrUpdate(Driver driver) {
			try {
				driver.setId(driver.getId());
			    return driverRepository.save(driver);
			}catch(Exception e)
			{
				throw new DriverIDException("Driver Id "+driver.getId()+" already exists");
			}
			
		}

	@Override
	public List<Driver> viewBestDrivers() {
		List<Driver> allDrivers=new ArrayList<>();
		allDrivers=driverRepository.findAll();
		List<Driver> bestDrivers=allDrivers.stream().filter(d->d.getRating()>=4.5).collect(Collectors.toList());
		return bestDrivers;
	}

	
	@Override
	public Driver viewDriverDetails(long driverId) {
		Driver driver = driverRepository.findById(driverId);
		if(driver==null)
		{
			throw new DriverIDException("Driver Id "+driverId+" does not exist");
		}
		return driver;
		
		}
	
	
	@Override
	public Driver deleteDriver(long driverId) {
		Driver driver=viewDriverDetails(driverId);
		driverRepository.delete(driver);
		return driver;
	}

	@Override
	public Driver viewDriverDetailsByEmail(String email){
		try {
			Driver driver = driverRepository.findByEmail(email);
			if(driver==null) {
				throw new DriverIDException("Driver with "+driver.getId()+" not Found");
			}
			return driver;
		}catch(Exception e)
		{
			throw new DriverIDException("Driver not found with this email id");
		}
		}
	
		
	}
	
	

