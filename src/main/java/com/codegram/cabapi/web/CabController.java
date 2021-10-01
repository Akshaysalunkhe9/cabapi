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

import com.codegram.cabapi.domain.Cab;
import com.codegram.cabapi.service.CabService;
import com.codegram.cabapi.service.MapValidationErrorService;

@RestController
@RequestMapping("/api/cabs")
public class CabController {

		@Autowired
		private CabService CabService;
	
		@Autowired
		private MapValidationErrorService mapValidationErrorService;
		@PostMapping("")
		public ResponseEntity<?> registerNewCustomer(@Valid @RequestBody Cab cab , BindingResult result){
			ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
			if(errorMap!=null) return errorMap;
			Cab savedCab = CabService.saveOrUpdate(cab);
			return new ResponseEntity<Cab>(savedCab,HttpStatus.CREATED);
	}
	
}
