package com.codegram.cabapi.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codegram.cabapi.domain.Cab;
import com.codegram.cabapi.repository.CabRepository;
import com.codegram.cabapi.service.CabService;

@Service
public class CabServiceImpl implements CabService{

	@Autowired
	private CabRepository cabRepository;
	
	@Override
	public Cab saveCab(Cab cab) {
		
		return cabRepository.save(cab);
	}

	@Override
	public Cab updateCab(Cab cab) {
		//Cab updateCab =CabRepository.findById((long) cab.getCabId()).get();
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
		Cab customer=viewCabDetails(cabId);
		cabRepository.delete(customer);
		return customer;
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
