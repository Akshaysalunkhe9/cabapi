package com.codegram.cabapi.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codegram.cabapi.domain.Admin;
import com.codegram.cabapi.service.AdminService;
import com.codegram.cabapi.service.MapValidationErrorService;
/**
 * 
 * @author Aniket
 *
 */
@RestController
@RequestMapping("/api/admins")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	
	@PostMapping("")
	public ResponseEntity<?> insertNewAdmin(@Valid @RequestBody Admin admin, BindingResult result){
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if(errorMap!=null) return errorMap;

		Admin insertAdmin = adminService.insertAdmin(admin);
		
		return new ResponseEntity<Admin>(insertAdmin, HttpStatus.CREATED);
		
		
		}
	
	@PutMapping("")
	public ResponseEntity<?> updateAdmin(@Valid @RequestBody Admin admin, BindingResult result) {
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if(errorMap!=null)
			return errorMap;
		Admin updation = adminService.updateAdmin(admin);
		return new ResponseEntity<Admin>(updation, HttpStatus.OK);
	}
		@DeleteMapping("/{adminId}")
		public ResponseEntity<?> deleteAdmin(@PathVariable Integer adminId) {
			adminService.deleteAdmin(adminId);
			return new ResponseEntity<String>("Admin with id: '"+adminId+"' is deleted", HttpStatus.OK);
		}
		
		@GetMapping("/{adminId}")
		public ResponseEntity<?> getAdminById(@PathVariable Integer adminId){
			Admin admin = adminService.viewAdminById(adminId);
			return new ResponseEntity<Admin>(admin, HttpStatus.OK);
		
		
	}
}

	