package com.codegram.cabapi.service;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.codegram.cabapi.domain.Admin;

import com.codegram.cabapi.domain.TripBooking;

import com.codegram.cabapi.domain.Customer;

import java.util.List;

public interface AdminService {

	public Admin insertAdmin (Admin admin);
	
	public Admin updateAdmin(Admin admin);
	
	public Iterable<Admin> deleteAdmin(int adminId);
	
	public Admin viewAdminById(int adminId);
	
	public Admin viewAdminDetailsByEmail(String email);
	
	public List<TripBooking> viewAllTripsCustomer(int customerId);
	
	public List<TripBooking> viewTripsDateWise();


	}