package com.codegram.cabapi.service;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.codegram.cabapi.domain.Admin;

//import com.codegram.cabapi.domain.TripBooking;

//import com.codegram.cabapi.domain.Customer;
import com.codegram.cabapi.domain.Operator;

import java.util.List;

public interface OperatorService {

	public Operator insertOperator (Operator operator);
	
	public Operator updateOperator(Operator operator);
	
	public Iterable<Operator> deleteOperator(int operatorId);
	
	public Operator viewOperatorById(int operatorId);
	
	//public Admin viewAdminDetailsByEmail(String email);
	
	//public List<TripBooking> viewAllTripsCustomer(int customerId);
	
	//public List<TripBooking> viewTripsDateWise();


	}