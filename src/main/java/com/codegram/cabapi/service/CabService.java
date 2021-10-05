package com.codegram.cabapi.service;

import java.util.List;

import com.codegram.cabapi.domain.Cab;


/**
 * This CapService interface will hold the functionality for Cab Related Business logic
 * @author Abhijit
 *
 */

public interface CabService {

		/**
		 * This insert method will insert the cab. 
		 * @param cab id will be given 
		 * @return the inserted cab
		 */
		public Cab saveCab(Cab cab);
		/**
		 * This update method will update the cab. 
		 * @param cab id will be given 
		 * @return the updated cab
		 */
		public Cab updateCab(Cab cab);
		/**
		 * This view method will delete the customer with his id. 
		 * @param Cab id will be given
		 * @return cab deleted by the id.
		 */
		public Cab viewCabDetails(int cabId);
		/**
		 * This delete method will delete the cab. 
		 * @param cab id will be given 
		 * @return the cab id along with its detail is deleted
		 */
		public Cab deleteCab(int cabId);
		/**
		 * This find method will view all the cab details. 
		 * @return the details of cab
		 */
		public Iterable<Cab> findAll();
		/**
		 * This view method will view the cab by car type. 
		 * @param cab type will be given 
		 * @return the cab with same car type 
		 */
		public List<Cab> viewCabsOfType(String carType);
		//public int countCabsOfType(String carType);
		
}