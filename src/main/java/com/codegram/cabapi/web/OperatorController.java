package com.codegram.cabapi.web;

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

import com.codegram.cabapi.domain.Operator;
import com.codegram.cabapi.service.MapValidationErrorService;
import com.codegram.cabapi.service.OperatorService;

@RestController
@RequestMapping("/api/operators")
public class OperatorController {

	@Autowired
	private OperatorService operatorService;
	
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	
	@PostMapping("")
	public ResponseEntity<?> insertNewOperator(@Valid @RequestBody Operator operator, BindingResult result){
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if(errorMap!=null) return errorMap;

		Operator insertOperator = operatorService.insertOperator(operator);
		
		return new ResponseEntity<Operator>(insertOperator, HttpStatus.CREATED);
		
		
		}
	
	@PutMapping("")
	public ResponseEntity<?> updateOperator(@Valid @RequestBody Operator operator, BindingResult result) {
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if(errorMap!=null)
			return errorMap;
		Operator updation = operatorService.updateOperator(operator);
		return new ResponseEntity<Operator>(updation, HttpStatus.OK);
	}
		@DeleteMapping("/{operatorId}")
		public ResponseEntity<?> deleteOperator(@PathVariable Integer operatorId) {
			operatorService.deleteOperator(operatorId);
			return new ResponseEntity<String>("Operator with id: '"+operatorId+"' is deleted", HttpStatus.OK);
		}
	
		@GetMapping("/{operatorId}")
		public ResponseEntity<?> getAdminById(@PathVariable Integer operatorId){
			Operator operator = operatorService.viewOperatorById(operatorId);
			return new ResponseEntity<Operator>(operator, HttpStatus.OK);
		
		
	}
}