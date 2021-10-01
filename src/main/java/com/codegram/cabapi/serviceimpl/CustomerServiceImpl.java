package com.codegram.cabapi.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codegram.cabapi.domain.Customer;
import com.codegram.cabapi.repository.CustomerRepository;
import com.codegram.cabapi.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Customer registerCustomer(Customer customer) {
		
		return customerRepository.save(customer);
	}

	
}
