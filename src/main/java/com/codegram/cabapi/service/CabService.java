package com.codegram.cabapi.service;

import java.util.List;

import com.codegram.cabapi.domain.Cab;


public interface CabService {

		public Cab insertCab(Cab cab);
		public Cab updateCab(Cab cab);
		public Cab deleteCab(Cab cab);
		public List<Cab> viewCabsOfType(String carType);
		public int countCabsOfType(String carType);
		
}
