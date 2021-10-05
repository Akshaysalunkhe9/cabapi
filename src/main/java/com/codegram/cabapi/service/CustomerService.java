package com.codegram.cabapi.service;

import org.springframework.stereotype.Service;

import com.codegram.cabapi.domain.Customer;

/**
 * This CustomerService interface will hold the functionality for Customer Related Business logic
 * @author Akshay
 *
 */


public interface CustomerService {
	/**
	 * This register method will save and register the customer if id not provided otherwise update. 
	 * @param customer  to be register or updated
	 * @return the Saved customer
	 */

	public Customer registerCustomer(Customer customer);
	
	/**
	 * This register method will update the customer. 
	 * @param customer  to be updated.
	 * @return the Saved/updated customer
	 */
	public Customer updateCustomer(Customer customer);
	/**
	 * This update method will show the entire details of the customer with his id. 
	 * @param customer  id will be given
	 * @return the customer with all the details.
	 */
	
	public Customer viewCustomerDetails(int customerId);
	
	/**
	 * This view method will delete the customer with his id. 
	 * @param customer  id will be given
	 * @return customer deleted by the id.
	 */
	public Customer deleteCustomer(int customerId);
	
	
	public Customer viewCustomerDetailsByName(String username);
	
	/**
	 * This view method will show the entire details of the customer with his email. 
	 * @param customer  email will be given
	 * @return the customer with all the details if mail is present.
	 */
	public Customer viewCustomerDetailsByEmail(String email);
	
}