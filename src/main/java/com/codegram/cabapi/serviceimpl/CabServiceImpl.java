package com.codegram.cabapi.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codegram.cabapi.domain.Cab;
import com.codegram.cabapi.domain.Driver;
import com.codegram.cabapi.exception.CabIDException;
import com.codegram.cabapi.repository.CabRepository;
import com.codegram.cabapi.repository.DriverRepository;
import com.codegram.cabapi.service.CabService;

@Service
public class CabServiceImpl implements CabService{

	@Autowired
	private CabRepository cabRepository;
	
	@Autowired
	private DriverRepository driverRepository;
	
	@Override
	public Cab saveCab(Cab cab) {
		//try {
				
					/*Driver driver=new Driver();
					cab.setDriver(driver);
					driver.setCab(cab);*/
					return cabRepository.save(cab);
		//}catch(Exception e) {
		//	throw new CabIDException("Project Id "+cab.getCabId()+" already exists");
		//}
		
	}

	@Override
	public Cab updateCab(Cab cab) {
		
		Cab updateCab = cabRepository.findByCabId(cab.getCabId());
		if (updateCab != null) {
			updateCab.setCarType(cab.getCarType());
			updateCab.setPerKmRate(cab.getPerKmRate());
			cabRepository.save(updateCab);
		}
		return updateCab;
	}

	@Override
	public Cab viewCabDetails(int cabId) {
		Cab viewCab = cabRepository.findByCabId(cabId);	
		return viewCab;
		
	}	
	
	@Override
	public Cab deleteCab(int cabId) {
		Cab cab=viewCabDetails(cabId);
		cabRepository.delete(cab);
		return cab;
	}

	@Override
	public Iterable<Cab> findAll() {
		
		return cabRepository.findAll();
	}
	
	/*
	@Override
	public List<Cab> viewCabsOfType(String carType) {
		
		return cabRepository.viewCabsOfType(carType);
	}
	*/

	@Override
	public int countCabsOfType(String carType) {
		
		return 0;
	}

	

	

	

	

}