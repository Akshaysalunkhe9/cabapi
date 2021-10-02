package com.codegram.cabapi.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codegram.cabapi.domain.Customer;
import com.codegram.cabapi.exception.CustomerIDException;
import com.codegram.cabapi.repository.CustomerRepository;
import com.codegram.cabapi.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Customer registerCustomer(Customer customer) {
		try {
			return customerRepository.save(customer);
		}
		catch(Exception e) {
			throw new CustomerIDException("Customer Id"+customer.getId()+"Already Exists");
		}
			
		
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		try {
			Customer updateCustomer = customerRepository.findById(customer.getId());
			if(updateCustomer==null) {
				throw new Exception("Customer Id not Found");
			}
			if(updateCustomer!=null) {
				updateCustomer.setEmail(customer.getEmail());
				updateCustomer.setAddress(customer.getAddress());
				updateCustomer.setMobileNumber(customer.getMobileNumber());
				updateCustomer.setPassword(customer.getPassword());
				updateCustomer.setUsername(customer.getUsername());
			}
			return customerRepository.save(updateCustomer);
		}catch(Exception e) {
			throw new CustomerIDException("Customer Id"+customer.getId() +"not found");
		}
		
	}

	@Override
	public Customer viewCustomerDetails(int customerId) {
		// TODO Auto-generated method stub
		try {
			Customer viewCustomer = customerRepository.findById(customerId);
			if(viewCustomer==null) {
				throw new Exception("Customer Id not Found");
			}
			return viewCustomer;
		}catch(Exception e) {
			throw new CustomerIDException("Customer Id"+customerId +"not found");
		}
	}
		
		

	@Override
	public Customer deleteCustomer(int customerId) {
		Customer customer=viewCustomerDetails(customerId);
		customerRepository.delete(customer);
		return customerRepository.findById(customerId);
		
	}

	@Override
	public Customer viewCustomerDetailsByName(String username) {
		Customer customer = customerRepository.findByUsername(username);
		return customer;
	}

	
}
