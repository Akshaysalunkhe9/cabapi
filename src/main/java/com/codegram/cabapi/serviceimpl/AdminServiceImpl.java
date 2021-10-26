package com.codegram.cabapi.serviceimpl;

import java.util.List;
import java.time.LocalDateTime;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.codegram.cabapi.domain.Admin;
import com.codegram.cabapi.domain.Cab;
import com.codegram.cabapi.exception.AdminIDException;
import com.codegram.cabapi.repository.AdminRepository;
import com.codegram.cabapi.service.AdminService;
import com.codegram.cabapi.domain.TripBooking;
import com.codegram.cabapi.domain.Customer;
import java.util.stream.Collectors;


/**
 * This AdminServiceImplementation  will implement all the methods from the AdminService Interface
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
		Admin admin = adminRepository.findById(adminId);
		if(admin == null)
			throw new AdminIDException("Admin ID :"+adminId+" does not exist");
		return admin;
	}
	
	
		@Override
		public Admin viewAdminDetailsByEmail(String email) {
			Admin admin = adminRepository.findByEmail(email);
			return admin;
	
   }
		
		
		@Override
		public Admin viewAdminDetailsByUsername(String username) {
			Admin admin = adminRepository.findByUsername(username);
			return admin;
	
   }
		@Override
		public Iterable<Admin> findAll() {
			return adminRepository.findAll();
	}
		
	    @Override
		public List<TripBooking> viewTripsDateWise() {
			TypedQuery<TripBooking> q = em.createQuery("select tb from TripBooking tb", TripBooking.class);
			List<TripBooking> trips = q.getResultList();
			trips = trips.stream().sorted((a, b) -> a.getFromDateTime().compareTo(b.getFromDateTime()))
					.collect(Collectors.toList());
			return trips;
			
		}
	    
	   
	    
		@Override
		public List<TripBooking> getTripsCustomerwise() {
			TypedQuery<TripBooking> q = em.createQuery("select tb from TripBooking tb", TripBooking.class);
			List<TripBooking> trips = q.getResultList();
			trips = trips.stream().sorted((a, b) -> a.getCustomer().getId() - b.getCustomer().getId())
					.collect(Collectors.toList());
			return trips;
		}
		
		
		
		@Override
		public Long totalTripsTaken() {
			TypedQuery<Long> q = em.createQuery("select COUNT(*) from TripBooking", Long.class);
			Long result = q.getSingleResult();
			return result;
		}
		
		
		
		@Override
		public Long totalCustomersPresent() {
			TypedQuery<Long> q = em.createQuery("select COUNT(*) from Customer", Long.class);
			Long result = q.getSingleResult();
			return result;
		}
		
		
		
		@Override
		public Long totalDriversPresent() {
			TypedQuery<Long> q = em.createQuery("select COUNT(*) from Driver", Long.class);
			Long result = q.getSingleResult();
			return result;
		}
		

//		@Override
//		public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//			// TODO Auto-generated method stub
//			Admin admin = adminRepository.findByEmail(email);
//			if(admin == null)
//				throw new UsernameNotFoundException("Admin not found");
//			//return new Admin(admin.getEmail(), admin.getPassword(), new ArrayList<>());
//			//return new AdminPrincipal(admin);
//			return admin;
//		}


}