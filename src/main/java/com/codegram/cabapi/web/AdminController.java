package com.codegram.cabapi.web;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.codegram.cabapi.domain.Admin;
import com.codegram.cabapi.service.AdminService;
import com.codegram.cabapi.service.MapValidationErrorService;
/**
 * 
 * @author Anand
 *
 */
@RestController
@RequestMapping("/api/admins")
public class AdminController {

	@Autowired
	private AdminService adminservice;
	
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	
	@PostMapping("")
	public ResponseEntity<?> insertNewAdmin(@Valid @RequestBody Admin admin, BindingResult result){
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if(errorMap!=null) return errorMap;

		Admin insertAdmin = adminservice.insertAdmin(admin);
		

		return new ResponseEntity<Admin>(insertAdmin, HttpStatus.CREATED);
	}
	
	@PatchMapping("/{adminId}")
	public ResponseEntity<?> updateAdmin(@Valid @RequestBody Admin admin , BindingResult result){
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if(errorMap!=null) return errorMap;
		Admin updateAdmin = adminservice.updateAdmin(admin);
		return new ResponseEntity<Admin>(updateAdmin,HttpStatus.OK);
	}
}