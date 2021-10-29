package com.codegram.cabapi.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping("/api/tripbookings")
public class TripBookingController {
	@Autowired
	private TripBookingService tripBookingService;
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/{customerId}/{cabId}/{driverId}")
	public ResponseEntity<?> createNewTrip(@Valid @RequestBody TripBooking tripBooking, BindingResult result, @PathVariable Integer customerId, @PathVariable Integer cabId, @PathVariable Integer driverId) {
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if(errorMap!=null) 
			return errorMap;
		TripBooking insertTrip = tripBookingService.insertTripBooking(tripBooking, customerId, cabId, driverId);
		return new ResponseEntity<TripBooking>(insertTrip, HttpStatus.CREATED);
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@PutMapping("")
	public ResponseEntity<?> updateTrip(@Valid @RequestBody TripBooking tripBooking, BindingResult result) {
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if(errorMap!=null)
			return errorMap;
		TripBooking updation = tripBookingService.updateTripBooking(tripBooking);
		return new ResponseEntity<TripBooking>(updation, HttpStatus.OK);
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping("/{tripBookingId}")
	public ResponseEntity<?> deleteTrip(@PathVariable Integer tripBookingId) {
		tripBookingService.deleteTripBooking(tripBookingId);
		return new ResponseEntity<String>("Trip with id: '"+tripBookingId+"' is deleted", HttpStatus.OK);
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/all")
	public Iterable<TripBooking> getAllTrips(){
		return tripBookingService.findAll();
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/{tripBookingId}")
	public ResponseEntity<?> getTripById(@PathVariable Integer tripBookingId){
		TripBooking tripBooking = tripBookingService.viewTripById(tripBookingId);
		return new ResponseEntity<TripBooking>(tripBooking, HttpStatus.OK);
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/customer/{customerId}")
	public List<TripBooking> viewAllTripsCustomer(@PathVariable Integer customerId){
		return tripBookingService.viewAllTripsCustomer(customerId);
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/calculate/{customerId}")
	public float calculateBill(@PathVariable Integer customerId) {
		return tripBookingService.calculateTotalBill(customerId);
	}

}
