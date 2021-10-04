package com.codegram.cabapi.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.codegram.cabapi.exception.*;
import com.codegram.cabapi.domain.Cab;
import com.codegram.cabapi.domain.Driver;
import com.codegram.cabapi.domain.TripBooking;
import com.codegram.cabapi.repository.CabRepository;
import com.codegram.cabapi.repository.DriverRepository;
import com.codegram.cabapi.service.DriverService;

@Service
public class DriverServiceImpl implements DriverService {

	@Autowired
	private DriverRepository driverRepository; 
	
	@Autowired
	private CabRepository cabRepository;
	
	@Override
	public Driver saveOrUpdate(Driver driver) {
			return driverRepository.save(driver);
		}

	@Override
	public List<Driver> viewBestDrivers() {
		List<Driver> allDrivers=new ArrayList<>();
		allDrivers=driverRepository.findAll();
		List<Driver> bestDrivers=allDrivers.stream().filter(d->d.getRating()>4.5).collect(Collectors.toList());
		return bestDrivers;
	}

	@Override
	public Driver viewDriverDetails(int driverId) {
		Driver driver= driverRepository.findByDriverId(driverId);
		return driver;
	}

	@Override
	public Driver deleteDriver(int driverId) {
		Driver driver=viewDriverDetails(driverId);
		driverRepository.delete(driver);
		return driver;
	}
	@Override
	public Iterable<Driver> findAll() {
		return driverRepository.findAll();
	}
	@Override
	public Driver viewDriverDetailsByEmail(String email) {
		try {
			Driver driver = driverRepository.findByEmail(email);
			if(driver==null) {
				throw new DriverIDException("Driver with "+driver.getDriverId()+"not Found");
			}
			return driver;
		}
		catch(Exception e) {
			throw new DriverIDException("Driver with this email id not found");
		}
	}

}