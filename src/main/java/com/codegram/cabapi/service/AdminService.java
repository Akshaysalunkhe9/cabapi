package com.codegram.cabapi.service;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.codegram.cabapi.domain.Admin;



public interface AdminService {

	public Admin insertAdmin (Admin admin);
	
	public Admin updateAdmin(Admin admin);
	
	public Iterable<Admin> deleteAdmin(int adminId);
	
	
	}