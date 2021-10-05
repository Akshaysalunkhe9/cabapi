package com.codegram.cabapi.web;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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

import com.codegram.cabapi.domain.Admin;
import com.codegram.cabapi.service.AdminService;
import com.codegram.cabapi.service.MapValidationErrorService;
import com.codegram.cabapi.domain.Customer;
import com.codegram.cabapi.domain.TripBooking;
/**
 * 
 * @author Aniket
 *
 */
@RestController
@RequestMapping("/api/admins")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	
	@PostMapping("")
	public ResponseEntity<?> insertNewAdmin(@Valid @RequestBody Admin admin, BindingResult result){
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if(errorMap!=null) return errorMap;

		Admin insertAdmin = adminService.insertAdmin(admin);
		
		return new ResponseEntity<Admin>(insertAdmin, HttpStatus.CREATED);
		
		
		}
	
	@PutMapping("")
	public ResponseEntity<?> updateAdmin(@Valid @RequestBody Admin admin, BindingResult result) {
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if(errorMap!=null)
			return errorMap;
		Admin updation = adminService.updateAdmin(admin);
		return new ResponseEntity<Admin>(updation, HttpStatus.OK);
	}
	
	@DeleteMapping("/{adminId}")
	public ResponseEntity<?> deleteAdmin(@PathVariable Integer adminId) {
		adminService.deleteAdmin(adminId);
		return new ResponseEntity<String>("Admin with id: '"+adminId+"' is deleted", HttpStatus.OK);
	}

	@GetMapping("/{adminId}")
	public ResponseEntity<?> getAdminById(@PathVariable Integer adminId){
		Admin admin = adminService.viewAdminById(adminId);
		return new ResponseEntity<Admin>(admin, HttpStatus.OK);	
	}
	@GetMapping("email/{email}")
	public ResponseEntity<?> viewAdminDetailsByEmail(@PathVariable String email){
		Admin admin=adminService.viewAdminDetailsByEmail(email);
		return new ResponseEntity<Admin>(admin,HttpStatus.OK);
	}
	
	@GetMapping("/customer/{customerId}")
		public List<TripBooking> viewAllTripsCustomer(@PathVariable Integer customerId){
			return adminService.viewAllTripsCustomer(customerId);
}
	@GetMapping("/datewise")
	public List<TripBooking> viewTripsDateWise(){
       return adminService.viewTripsDateWise();
	}
	@GetMapping("/customerwise")
	public List<TripBooking> getTripsCustomerwise() {
		return adminService.getTripsCustomerwise();
	}
	
	@GetMapping("/trips")
	public ResponseEntity<?> getTotalTrips(){
		Long operator = adminService.totalTripsTaken();
		return new ResponseEntity<Long>(operator, HttpStatus.OK);
	}
	@GetMapping("/customers")
	public ResponseEntity<?> getTotalCustomers(){
		Long operator = adminService.totalCustomersPresent();
		return new ResponseEntity<Long>(operator, HttpStatus.OK);
	}
	@GetMapping("/drivers")
	public ResponseEntity<?> getTotalDrivers(){
		Long operator = adminService.totalDriversPresent();
		return new ResponseEntity<Long>(operator, HttpStatus.OK);
	}

}