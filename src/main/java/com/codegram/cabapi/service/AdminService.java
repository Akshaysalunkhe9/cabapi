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
	 * This method will view the admin details by his username. 
	 * @param admin username will be given
	 * @return admin details by the username.
	 */
	
	public Admin viewAdminDetailsByUsername(String username);
	
	/**
	 * This method will view the TripsBooking details datewise. 
	 * @param Datewise will be given
	 * @return  TripsBooking details by the Datewise.
	 */
	public List<TripBooking> viewTripsDateWise();
	
	/**
	 * This method will view the TripsBooking details customerwise. 
	 * @param Customerwise will be given
	 * @return  TripBooking details by the customerwise.
	 */
	public List<TripBooking> getTripsCustomerwise();
	
	/**
	 * This method will view all the Trips taken by customers. 
	 * @param trips will be given
	 * @return  totaltripstaken details.
	 */
	public Long totalTripsTaken();
	
	
	/**
	 * This method will view all thecustomers. 
	 * @param customers will be given
	 * @return  totalCustomers details.
	 */
	
	public Long totalCustomersPresent();
	
	/**
	 * This view method will display the totalDrivers details. 
	 * @param driver will be given
	 * @return total number of drivers.
	 */
	public Long totalDriversPresent();
	
//	public float totalIncome();

	}