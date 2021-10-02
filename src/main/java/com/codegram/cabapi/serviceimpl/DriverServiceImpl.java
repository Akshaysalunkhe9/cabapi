package com.codegram.cabapi.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codegram.cabapi.domain.Driver;
import com.codegram.cabapi.repository.DriverRepository;
import com.codegram.cabapi.service.DriverService;

@Service
public class DriverServiceImpl implements DriverService {

	@Autowired
	private DriverRepository driverRepository; 
	
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
	public Driver viewDriverDetails(long driverId) {
		Driver driver= driverRepository.findByDriverId(driverId);
		return driver;
	}

	@Override
	public Driver deleteDriver(long driverId) {
		Driver driver=viewDriverDetails(driverId);
		driverRepository.delete(driver);
		return driver;
	}


}