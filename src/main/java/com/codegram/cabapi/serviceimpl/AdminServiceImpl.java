package com.codegram.cabapi.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codegram.cabapi.domain.Admin;
import com.codegram.cabapi.repository.AdminRepository;
import com.codegram.cabapi.service.AdminService;
/**
 * 
 * @author Anand
 *
 */
@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminRepository adminRepository;
	@Override
	public Admin insertAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminRepository.save(admin);
	}
				

	@Override
	public Admin updateAdmin(Admin admin) {
		
		Admin updateAdmin = adminRepository.findByAdminId(admin.getAdminId());
		
		updateAdmin.setEmail(admin.getEmail());
		updateAdmin.setAddress(admin.getAddress());
		updateAdmin.setMobileNumber(admin.getMobileNumber());
		updateAdmin.setPassword(admin.getPassword());
		updateAdmin.setUsername(admin.getUsername());
		adminRepository.save(updateAdmin);
		
		return updateAdmin;

	}
	

}