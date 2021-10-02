package com.codegram.cabapi.service;


import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public interface MapValidationErrorService {
	public ResponseEntity<?> mapValidationError(BindingResult result);

}