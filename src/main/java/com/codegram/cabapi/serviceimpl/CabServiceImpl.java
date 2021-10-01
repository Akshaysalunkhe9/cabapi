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
	private CabRepository CabRepository;
	
	@Override
	public Cab saveOrUpdate(Cab cab) {
		
		return CabRepository.save(cab);
	}
	
	@Override
	public Cab insertCab(Cab cab) {
		
		return null;
	}

	@Override
	public Cab updateCab(Cab cab) {
		
		return null;
	}

	@Override
	public Cab deleteCab(Cab cab) {
		
		return null;
	}

	@Override
	public List<Cab> viewCabsOfType(String carType) {
		
		return null;
	}

	@Override
	public int countCabsOfType(String carType) {
		
		return 0;
	}

	

}
