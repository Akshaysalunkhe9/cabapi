package com.codegram.cabapi.service;

import org.springframework.stereotype.Service;

import com.codegram.cabapi.domain.Customer;




public interface CustomerService {

	public Customer registerCustomer(Customer customer);
	
	public Customer updateCustomer(Customer customer);
	
	public Customer viewCustomerDetails(int customerId);
	
	public Customer deleteCustomer(int customerId);
	
	public Customer viewCustomerDetailsByName(String username);
	
}