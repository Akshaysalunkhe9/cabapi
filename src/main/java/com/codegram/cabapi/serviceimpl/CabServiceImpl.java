package com.codegram.cabapi.serviceimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codegram.cabapi.domain.Cab;
import com.codegram.cabapi.exception.CabIDException;
import com.codegram.cabapi.exception.CabTypeException;
import com.codegram.cabapi.repository.CabRepository;
import com.codegram.cabapi.service.CabService;

@Service
public class CabServiceImpl implements CabService{

	@Autowired
	private CabRepository cabRepository;
	
	@PersistenceContext
	EntityManager em;
	
	@Override
	public Cab saveCab(Cab cab) {
		try {
				
					/*Driver driver=new Driver();
					cab.setDriver(driver);
					driver.setCab(cab);*/
					return cabRepository.save(cab);
		}catch(Exception e) {
		throw new CabIDException("Cab Id "+cab.getCabId()+" already exists");
		}
		
	}

	@Override
	public Cab updateCab(Cab cab) {
		
		Cab updateCab = cabRepository.findByCabId(cab.getCabId());
		if (updateCab != null) {
			updateCab.setCarType(cab.getCarType());
			updateCab.setPerKmRate(cab.getPerKmRate());
			cabRepository.save(updateCab);
		}
		return cabRepository.save(cab);
	}

	@Override
	public Cab viewCabDetails(int cabId) {
		try {
				Cab viewCab = cabRepository.findByCabId(cabId);	
				if(viewCab==null) {
					throw new Exception("Cab Id not Found");
			}
				return viewCab;
		}catch(Exception e) {
			throw new CabIDException("Customer Id "+cabId+" not found");
		}
		
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
	public List<Cab> viewCabsOfType(String carType) throws CabTypeException {
		try {
					List<Cab> viewCab = cabRepository.findByCarType(carType);
					TypedQuery<Cab> q = em.createQuery("select cb from Cab cb where carType = :carType", Cab.class);
					q.setParameter("carType", carType);
					q.getResultList();
					if(viewCab==null) {
						throw new Exception("Cab Type not Found");
					}
					
				return q.getResultList();
		}catch(Exception e) {
			throw new CabTypeException("cab Type not found");
		}
		
	}
	

	
	
	@Override
	public int countCabsOfType(String carType) {
		
		return 0;
	}

	


	

	

	

	

}
