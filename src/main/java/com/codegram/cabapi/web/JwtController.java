package com.codegram.cabapi.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codegram.cabapi.config.helper.JwtUtil;
import com.codegram.cabapi.domain.Admin;
import com.codegram.cabapi.domain.JwtResponse;
import com.codegram.cabapi.service.AdminService;

@RestController
public class JwtController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private AdminService adminService;
	@Autowired
	private JwtUtil jwtUtil;
	
	
	@RequestMapping(value="/api/token", method=RequestMethod.POST)
	public ResponseEntity<?> generateToken(@Valid @RequestBody Admin admin, BindingResult result) throws Exception {
		try {
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(admin.getEmail(), admin.getPassword()));
		} 
		catch (UsernameNotFoundException e) {
			throw new Exception("Bad Credentials");
		}
		catch (BadCredentialsException e) {
			e.printStackTrace();
			throw new Exception("Bad Credentials");
		}
		
		//fine area
		UserDetails userDetails = this.adminService.loadUserByUsername(admin.getEmail());
		String token = this.jwtUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new JwtResponse(token));
		
	}

}
