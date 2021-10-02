package com.codegram.cabapi.serviceimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codegram.cabapi.domain.Admin;
import com.codegram.cabapi.exception.AdminIDException;
import com.codegram.cabapi.repository.AdminRepository;
import com.codegram.cabapi.service.AdminService;


/**
 * @author Aniket
 *
 */
@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminRepository adminRepository;
	@PersistenceContext
	EntityManager em;

	@Override
	public Admin insertAdmin(Admin admin) {
		// TODO Auto-generated method stub
		 adminRepository.save(admin);
		return admin;
	}

	@Override
	public Admin updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminRepository.save(admin);
	}

	@Override
	public Iterable<Admin> deleteAdmin(int adminId) {
		// TODO Auto-generated method stub
		adminRepository.deleteById(adminId);
		return adminRepository.findAll();

	}
	
	@Override
	public Admin viewAdminById(int adminId) {
		Admin admin = adminRepository.findByadminId(adminId);
		if(admin == null)
			throw new AdminIDException("Admin ID :"+adminId+" does not exist");
		return admin;
	
}
}