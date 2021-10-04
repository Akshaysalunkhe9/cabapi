package com.codegram.cabapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class OperatorResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler
	public final ResponseEntity<Object> handleDriverIDException(OperatorIDException ex, WebRequest request)
	{
		OperatorIDExceptionResponse exceptionResponse = new OperatorIDExceptionResponse(ex.getMessage());
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
		
	}
	}