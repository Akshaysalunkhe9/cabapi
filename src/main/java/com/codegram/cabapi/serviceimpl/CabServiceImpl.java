package com.codegram.cabapi.serviceimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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
	
//	@Autowired
//	private DriverRepository driverRepository;
	
	@PersistenceContext
	EntityManager em;
	
	@Override
	public Cab saveCab(Cab cab) {
//			Driver driver= driverRepository.findByDriverId(driverId);
//			cab.setDriver(driver);
//			//driver.setCab(cab);
			cabRepository.save(cab);
			return cab;
	}

	@Override
	public Cab updateCab(Cab cab) {
		
		Cab updateCab = cabRepository.findById(cab.getId());
		if (updateCab != null) {
			updateCab.setCarType(cab.getCarType());
			updateCab.setPerKmRate(cab.getPerKmRate());
			cabRepository.save(updateCab);
		}
		return updateCab;
	}

	@Override
	public Cab viewCabDetails(int cabId) {
		Cab viewCab = cabRepository.findById(cabId);	
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
	
	
	@Override
	public List<Cab> viewCabsOfType(String carType) {
		
		List<Cab> viewCab = cabRepository.findByCarType(carType);
		TypedQuery<Cab> q = em.createQuery("select cb from Cab cb where carType = :carType", Cab.class);
		q.setParameter("carType", carType);
		q.getResultList();
		return q.getResultList();
	}
	


}