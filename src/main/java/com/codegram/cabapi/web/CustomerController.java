package com.codegram.cabapi.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codegram.cabapi.domain.Customer;
import com.codegram.cabapi.service.CustomerService;
import com.codegram.cabapi.service.MapValidationErrorService;



@RestController
@RequestMapping("/api/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	
	@PostMapping("")
	public ResponseEntity<?> registerNewCustomer(@Valid @RequestBody Customer customer , BindingResult result){
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if(errorMap!=null) return errorMap;
		Customer registerCustomer = customerService.registerCustomer(customer);
		return new ResponseEntity<Customer>(customer,HttpStatus.CREATED);
		
	}
	
	@PatchMapping("/{customerId}")
	public ResponseEntity<?> updateCustomer(@Valid @RequestBody Customer customer , BindingResult result){
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if(errorMap!=null) return errorMap;
		Customer updateCustomer = customerService.updateCustomer(customer);
		return new ResponseEntity<Customer>(updateCustomer,HttpStatus.OK);
	}
	
	
	
}
