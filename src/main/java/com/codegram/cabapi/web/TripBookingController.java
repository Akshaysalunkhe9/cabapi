package com.codegram.cabapi.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codegram.cabapi.domain.TripBooking;
import com.codegram.cabapi.service.TripBookingService;
import com.codegram.cabapi.service.MapValidationErrorService;

/**
 * @author Arnav
 *
 */
@RestController
@RequestMapping("/api/tripbooking")
public class TripBookingController {
	@Autowired
	private TripBookingService tripBookingService;
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	
	@PostMapping("/{customerId}")
	public ResponseEntity<?> createNewTrip(@Valid @RequestBody TripBooking tripBooking, BindingResult result, @PathVariable Integer customerId) {
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if(errorMap!=null) 
			return errorMap;
		TripBooking insertTrip = tripBookingService.insertTripBooking(tripBooking, customerId);
		return new ResponseEntity<TripBooking>(insertTrip, HttpStatus.CREATED);
	}
	@PutMapping("")
	public ResponseEntity<?> updateTrip(@Valid @RequestBody TripBooking tripBooking, BindingResult result) {
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if(errorMap!=null)
			return errorMap;
		TripBooking updation = tripBookingService.updateTripBooking(tripBooking);
		return new ResponseEntity<TripBooking>(updation, HttpStatus.OK);
	}
	@DeleteMapping("/{tripBookingId}")
	public ResponseEntity<?> deleteTrip(@PathVariable Integer tripBookingId) {
		tripBookingService.deleteTripBooking(tripBookingId);
		return new ResponseEntity<String>("Trip with id: '"+tripBookingId+"' is deleted", HttpStatus.OK);
	}
	@GetMapping("/all")
	public Iterable<TripBooking> getAllTrips(){
		return tripBookingService.findAll();
	}
	@GetMapping("/{tripBookingId}")
	public ResponseEntity<?> getTripById(@PathVariable Integer tripBookingId){
		TripBooking tripBooking = tripBookingService.viewTripById(tripBookingId);
		return new ResponseEntity<TripBooking>(tripBooking, HttpStatus.OK);
	}
	@GetMapping("/customer/{customerId}")
	public List<TripBooking> viewAllTripsCustomer(@PathVariable Integer customerId){
		return tripBookingService.viewAllTripsCustomer(customerId);
	}
	@GetMapping("/calculate/{customerId}")
	public float calculateBill(@PathVariable Integer customerId) {
		return tripBookingService.calculateBill(customerId);
	}

}
