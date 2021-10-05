package com.codegram.cabapi.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codegram.cabapi.exception.CustomerIDException;
import com.codegram.cabapi.exception.OperatorIDException;
import com.codegram.cabapi.repository.CabRepository;
import com.codegram.cabapi.repository.CustomerRepository;
import com.codegram.cabapi.repository.DriverRepository;
import com.codegram.cabapi.repository.OperatorRepository;
import com.codegram.cabapi.repository.TripBookingRepository;
import com.codegram.cabapi.service.OperatorService;
import com.codegram.cabapi.domain.Customer;
//import com.codegram.cabapi.domain.TripBooking;
//import com.codegram.cabapi.domain.Customer;
import com.codegram.cabapi.domain.Operator;
import com.codegram.cabapi.domain.TripBooking;

import java.util.stream.Collectors;


/**
 * This OperatorServiceImplementation  will implement all the methods from the OperatorService Interface
 * @author anand
 *
 */
@Service
public class OperatorServiceImpl implements OperatorService {
//	@Autowired
//	private TripBookingRepository tripBookingRepository;
//	@Autowired
//	private CabRepository cabRepository;
//	@Autowired
//	private CustomerRepository customerRepository;
//	@Autowired
//	private DriverRepository driverRepository;
	@Autowired
	private OperatorRepository operatorRepository;
	@PersistenceContext
	EntityManager em;

	@Override
	public Operator insertOperator(Operator operator) {
//		// TODO Auto-generated method stub
//		 operatorRepository.save(operator);
//		return operator;
		try {
			return operatorRepository.save(operator);
		}
		catch(Exception e) {
			throw new OperatorIDException("Operator Id"+operator.getId() +"Already Exists");
		}
	}

	@Override
	public Operator updateOperator(Operator operator) {
//		// TODO Auto-generated method stub
//		return operatorRepository.save(operator);
		try {
			Operator updateOperator = operatorRepository.findById(operator.getId());
			if(updateOperator==null) {
				throw new Exception("Customer Id not Found");
			}
			if(updateOperator!=null) {
				updateOperator.setEmail(operator.getEmail());
				updateOperator.setAddress(operator.getAddress());
				updateOperator.setMobileNumber(operator.getMobileNumber());
				updateOperator.setPassword(operator.getPassword());
				updateOperator.setUsername(operator.getUsername());
			}
			return operatorRepository.save(updateOperator);
		}catch(Exception e) {
			throw new CustomerIDException("Operator Id"+operator.getId() +"not found");
		}
	}

	@Override
	public Iterable<Operator> deleteOperator(int operatorId) {
		// TODO Auto-generated method stub
		Operator operator= viewOperatorById(operatorId);
		operatorRepository.delete(operator);
		
		return operatorRepository.findAll();

	}

	@Override
	public Operator viewOperatorById(int operatorId) {
		Operator operator = operatorRepository.findById(operatorId);
		if(operator == null)
			throw new OperatorIDException("Operator ID :"+operatorId+" does not exist");
		return operator;
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
	@Override
	public Long totalCabsPresent() {
		TypedQuery<Long> q = em.createQuery("select COUNT(*) from Cab", Long.class);
		Long result = q.getSingleResult();
		return result;
	}
//	@Override
//	public float totalIncome() {
////		TypedQuery<Float> q = em.createQuery("select SUM(tb.bill) from TripBooking tb", Float.class);
////		Float result = q.getSingleResult();
////		return 0;
//		TypedQuery<TripBooking> q = em.createQuery("select tb from TripBooking tb", TripBooking.class);
//		List<TripBooking> list = q.getResultList();
//		Optional<Float> result = list.stream().map((tb) -> tb.getBill()).reduce((a,b) -> a+b);
//		return result.get();
//	}
	
}