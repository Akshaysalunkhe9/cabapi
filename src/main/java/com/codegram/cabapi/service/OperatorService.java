package com.codegram.cabapi.service;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.codegram.cabapi.domain.Admin;
import com.codegram.cabapi.domain.Cab;
import com.codegram.cabapi.domain.Customer;
import com.codegram.cabapi.domain.Driver;

//import com.codegram.cabapi.domain.TripBooking;

//import com.codegram.cabapi.domain.Customer;
import com.codegram.cabapi.domain.Operator;
import com.codegram.cabapi.domain.TripBooking;

import java.util.List;
/**
 * This OperatorService interface will hold the functionality for Operator Related Business logic
 * @author anand
 *
 */

public interface OperatorService {
	/**
	 * This  method will insert the operator details with his id. 
	 * @param operator id will be given
	 * @return operator inserted .
	 */
	
	public Operator insertOperator (Operator operator);
	/**
	 * This view method will display the operator details with his id. 
	 * @param operator id will be given
	 * @return operator inserted or update.
	 */
	
	public Operator updateOperator(Operator operator);
	 /**
		 * This view method will delete the operator with his id. 
		 * @param operator id will be given
		 * @return operator deleted by the id.
		 */
	
	public Operator deleteOperator(int operatorId);
	/**
	 * This view method will display the operator details with his id. 
	 * @param operator id will be given
	 * @return operator will be view.
	 */
	
	public Operator viewOperatorById(int operatorId);
	/**
	 * This view method will display the Trips details with his id. 
	 * @param tripbooking  id will be given
	 * @return total number of trips.
	 */
	public Long totalTripsTaken();
	/**
	 * This view method will display the customer details with his id. 
	 * @param customer  id will be given
	 * @return total number of customer.
	 */
	public Long totalCustomersPresent();
	/**
	 * This view method will display the driver details with his email. 
	 * @param driver  id will be given
	 * @return total number of drivers.
	 */
	public Long totalDriversPresent();
	/**
	 * This view method will display the cab details with his id. 
	 * @param cab id will be given
	 * @return total number of cabs.
	 */
	public Long totalCabsPresent();
//	public float totalIncome();

	}