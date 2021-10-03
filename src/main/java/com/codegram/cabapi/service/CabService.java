package com.codegram.cabapi.service;

import java.util.List;

import com.codegram.cabapi.domain.Cab;


public interface CabService {

		public Cab saveCab(Cab cab);
		public Cab updateCab(Cab cab);
		public Cab viewCabDetails(int cabId);
		public Cab deleteCab(int cabId);
		public Iterable<Cab> findAll();
		//public List<Cab> viewCabsOfType(String carType);
		public int countCabsOfType(String carType);
		
}