package com.codegram.cabapi.service;

import javax.validation.Valid;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.codegram.cabapi.domain.Admin;

import com.codegram.cabapi.domain.TripBooking;

import com.codegram.cabapi.domain.Customer;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Aniket
 *
 */
public interface AdminService extends UserDetailsService{

	/**
	 * This AdminService interface will hold the functionality for Admin Related Business logic
	 * @author aniket
	 *
	 */

	/**
	 * This  method will insert the admin details with his id. 
	 * @param admin id will be given
	 * @return admin inserted .
	 */
	public Admin insertAdmin (Admin admin);
	
	/**
	 * This method will update the admin with his id. 
	 * @param admin  id will be given
	 * @return admin updated by the id.
	 */
	
	public Admin updateAdmin(Admin admin);
	/**
	 * This method will delete the admin with his id. 
	 * @param admin  id will be given
	 * @return admin deleted by the id.
	 */
	public Iterable<Admin> deleteAdmin(int adminId);
	
	
	
	/**
	 * This  method will view the admin with his id. 
	 * @param admin id will be given
	 * @return admin view by the id.
	 */
	
	public Admin viewAdminById(int adminId);
	
	/**
	 * This method will view the admin details by his email. 
	 * @param admin email will be given
	 * @return admin details by the email id.
	 */
	
	public Admin viewAdminDetailsByEmail(String email);
	/**
	 * This method will view the TripsBooking details customerwise. 
	 * @param Customerwise will be given
	 * @return  TripBooking details by the customerwise.
	 */
	public List<TripBooking> viewAllTripsCustomer(int customerId);
	
	public List<TripBooking> viewTripsDateWise();
	/**
	 * This method will view the TripsBooking details customerwise. 
	 * @param Customerwise will be given
	 * @return  TripBooking details by the customerwise.
	 */
	public List<TripBooking> getTripsCustomerwise();
	
	public List<TripBooking> getAllTripsForDays(int customerId, LocalDateTime fromDate, LocalDateTime toDate);


	}