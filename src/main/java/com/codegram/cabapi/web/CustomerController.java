package com.codegram.cabapi.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@PutMapping("/{customerId}")
	public ResponseEntity<?> updateCustomer(@Valid @RequestBody Customer customer , BindingResult result){
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if(errorMap!=null) return errorMap;
		Customer updateCustomer = customerService.updateCustomer(customer);
		return new ResponseEntity<Customer>(updateCustomer,HttpStatus.OK);
	}
	
	@GetMapping("/{customerId}")
	public ResponseEntity<?> viewDriverById(@PathVariable Integer customerId){
		Customer customer=customerService.viewCustomerDetails(customerId);
		return new ResponseEntity<Customer>(customer,HttpStatus.OK);
	}
	
	@DeleteMapping("/{customerId}")
	public ResponseEntity<?> deleteDriverById(@PathVariable Integer customerId){
		customerService.deleteCustomer(customerId);
		return new ResponseEntity<String>("Customer with id '"+customerId+"' has been deleted successfully.",HttpStatus.OK);
	}
	
}