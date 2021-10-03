package com.codegram.cabapi.web;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This is the ProjectController and it is used for handling front end calls and generate json response. 
 * @author animesh
 *
 */
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codegram.cabapi.domain.Driver;
import com.codegram.cabapi.service.DriverService;
import com.codegram.cabapi.service.MapValidationErrorService;

@RestController
@RequestMapping("/api/driver")
public class DriverController {
	@Autowired
	private DriverService driverService;
	
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	
	@PostMapping("/{cabId}")
	public ResponseEntity<?> registerNewDriver(@Valid @RequestBody Driver driver, BindingResult result,@PathVariable int cabId){                                      
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if(errorMap!=null) return errorMap;
		Driver savedDriver = driverService.saveOrUpdate(driver,cabId);
		return new ResponseEntity<Driver>(savedDriver,HttpStatus.CREATED);
	}
	
	//List of all drivers
	@GetMapping("/{driverId}")
	public ResponseEntity<?> viewDriverById(@PathVariable long driverId){
		Driver driver=driverService.viewDriverDetails(driverId);
		return new ResponseEntity<Driver>(driver,HttpStatus.OK);
	}
	
	
	//Get best drivers with rating > 4.5
	@GetMapping("/bestdrivers")
	public ResponseEntity<?> viewBestDrivers(){
		List<Driver> bestDrivers=driverService.viewBestDrivers();
		return new ResponseEntity<List<Driver>>(bestDrivers,HttpStatus.OK);
	
}
	
	//Delete a driver based on driver id
	@DeleteMapping("/{driverId}")
	public ResponseEntity<?> deleteDriverById(@PathVariable Long driverId){
		driverService.deleteDriver(driverId);
		return new ResponseEntity<String>("Driver with id '"+driverId+"' has been deleted successfully.",HttpStatus.OK);
	}
	
}