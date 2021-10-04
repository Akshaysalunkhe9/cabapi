package com.codegram.cabapi.serviceimpl;

import java.util.List;
import java.time.LocalDateTime;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codegram.cabapi.domain.Admin;
import com.codegram.cabapi.exception.AdminIDException;
import com.codegram.cabapi.repository.AdminRepository;
import com.codegram.cabapi.service.AdminService;
import com.codegram.cabapi.domain.TripBooking;
import com.codegram.cabapi.domain.Customer;
import java.util.stream.Collectors;



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
		
		@Override
		public Admin viewAdminDetailsByEmail(String email) {
			Admin admin = adminRepository.findByEmail(email);
			return admin;
	
   }
		@Override
		public List<TripBooking> viewAllTripsCustomer(int customerId) {
			TypedQuery<TripBooking> q = em.createQuery("select tb from TripBooking tb where tb.customer.customerId=:customerId",TripBooking.class);
			q.setParameter("customerId", customerId);
			List<TripBooking> result = q.getResultList();
			return result;
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
			trips = trips.stream().sorted((a, b) -> a.getCustomer().getCustomerId() - b.getCustomer().getCustomerId())
					.collect(Collectors.toList());
			return trips;
		}
		@Override
		public List<TripBooking> getAllTripsForDays(int customerId, LocalDateTime fromDate, LocalDateTime toDate)
			       {
			TypedQuery<TripBooking> q = em.createQuery(
					"select tb from TripBooking tb where tb.customer.customerId=:cId and tb.fromDateTime between :start and :end",
					TripBooking.class);
			q.setParameter("cId", customerId);
			q.setParameter("start", fromDate);
			q.setParameter("end", toDate);
			List<TripBooking> trips = q.getResultList();
			return trips;
		}

}