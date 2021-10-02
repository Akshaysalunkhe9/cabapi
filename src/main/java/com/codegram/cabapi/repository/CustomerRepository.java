package com.codegram.cabapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codegram.cabapi.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
			
	Customer findByCustomerId(int Customerid);
	Customer findByUsername(String username);
}