package com.codegram.cabapi.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
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
@RequestMapping("/tripbooking")
public class TripBookingController {
	@Autowired
	private TripBookingService tripBookingService;
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	
	@PostMapping("")
	public ResponseEntity<?> insertTripBooking(@Valid @RequestBody TripBooking tripBooking, BindingResult result) {
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if(errorMap!=null) 
			return errorMap;
		TripBooking insertTrip = tripBookingService.insertTripBooking(tripBooking);
		return new ResponseEntity<TripBooking>(insertTrip, HttpStatus.CREATED);
	}
	

}
