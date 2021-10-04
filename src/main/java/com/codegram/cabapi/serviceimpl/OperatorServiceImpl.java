package com.codegram.cabapi.serviceimpl;

import java.util.List;
import java.time.LocalDateTime;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codegram.cabapi.exception.OperatorIDException;
import com.codegram.cabapi.repository.OperatorRepository;
import com.codegram.cabapi.service.OperatorService;
//import com.codegram.cabapi.domain.TripBooking;
//import com.codegram.cabapi.domain.Customer;
import com.codegram.cabapi.domain.Operator;

import java.util.stream.Collectors;



/**
 * @author Aniket
 *
 */
@Service
public class OperatorServiceImpl implements OperatorService {
	@Autowired
	private OperatorRepository operatorRepository;
	@PersistenceContext
	EntityManager em;

	@Override
	public Operator insertOperator(Operator operator) {
		// TODO Auto-generated method stub
		 operatorRepository.save(operator);
		return operator;
	}

	@Override
	public Operator updateOperator(Operator operator) {
		// TODO Auto-generated method stub
		return operatorRepository.save(operator);
	}

	@Override
	public Iterable<Operator> deleteOperator(int operatorId) {
		// TODO Auto-generated method stub
		operatorRepository.deleteById(operatorId);
		return operatorRepository.findAll();

	}


	@Override
	public Operator viewOperatorById(int operatorId) {
		Operator operator = operatorRepository.findByoperatorId(operatorId);
		if(operator == null)
			throw new OperatorIDException("Operator ID :"+operatorId+" does not exist");
		return operator;
	}
}