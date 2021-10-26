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
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codegram.cabapi.domain.Cab;
import com.codegram.cabapi.service.CabService;
import com.codegram.cabapi.service.MapValidationErrorService;

@RestController
@RequestMapping("/api/cabs")
public class CabController {

		@Autowired
		private CabService cabService;
	
		@Autowired
		private MapValidationErrorService mapValidationErrorService;
		@CrossOrigin(origins = "http://localhost:3000")
		@PostMapping("")
		public ResponseEntity<?> registerNewCab(@Valid @RequestBody Cab cab , BindingResult result){
			ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
			if(errorMap!=null) return errorMap;
			Cab savedCab = cabService.saveCab(cab);
			return new ResponseEntity<Cab>(savedCab,HttpStatus.CREATED);
		}
	
		@PatchMapping("/{cabId}")
		public ResponseEntity<?> updateCustomer(@Valid @RequestBody Cab cab , BindingResult result){
			ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
			if(errorMap!=null) return errorMap;
			Cab	updateCab = cabService.updateCab(cab);
			return new ResponseEntity<Cab>(updateCab,HttpStatus.OK);
		}
		
		@GetMapping("/{cabId}")
		public ResponseEntity<?> viewDriverById(@PathVariable int cabId){
			Cab deletecab=cabService.viewCabDetails(cabId);
			return new ResponseEntity<Cab>(deletecab,HttpStatus.OK);
		}
		@DeleteMapping("/{cabId}")
		public ResponseEntity<?> deleteCabById(@PathVariable int cabId){
			cabService.deleteCab(cabId);
			return new ResponseEntity<String>("Customer with id '"+cabId+"' has been deleted successfully.",HttpStatus.OK);
		}
		
		@GetMapping("/all")
		public Iterable<Cab> getAllProjects(){
			return cabService.findAll();
		}
		
		
		@GetMapping(value = "/type/{carType}")
		public List<Cab> viewCabsOfType(@PathVariable String carType) throws Exception {
			return cabService.viewCabsOfType(carType);
		}
		
}