package com.codegram.cabapi.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codegram.cabapi.domain.Cab;
import com.codegram.cabapi.domain.Driver;
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
	public Driver saveOrUpdate(Driver driver,int cabId) {
			
			Cab cab = new Cab();
			cab = cabRepository.findByCabId(cabId);
			driver.setCab(cab);
			
			
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

	@Override
	public Driver viewDriverDetailsByEmail(String email) throws Exception {
		try {
			Driver driver = driverRepository.findByEmail(email);
			if(driver==null) {
				throw new Exception("Driver with "+driver.getDriverId()+"not Found");
			}
			return driver;
		}
		catch(Exception e) {
			throw new Exception("Driver not found");
		}
	}

}