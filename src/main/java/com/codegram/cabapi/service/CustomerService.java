package com.codegram.cabapi.service;

import org.springframework.stereotype.Service;

import com.codegram.cabapi.domain.Customer;




public interface CustomerService {

	public Customer registerCustomer(Customer customer);
	
	public Customer updateCustomer(Customer customer);
	
	public Customer viewCustomerDetails(int id);
	
	public Customer deleteCustomer(int id);
	
	public Customer viewCustomerDetailsByName(String username);
	
}