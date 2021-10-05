package com.codegram.cabapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codegram.cabapi.domain.Customer;

/**
 * repository class which will be able to handle the crud operations in the layers of service implementations.
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
			
	Customer findById(int Customerid);
	Customer findByUsername(String username);
	Customer findByEmail(String email);
}