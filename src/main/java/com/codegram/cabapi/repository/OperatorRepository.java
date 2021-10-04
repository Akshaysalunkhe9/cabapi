package com.codegram.cabapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.codegram.cabapi.domain.Operator;


/**
 * @author Anand
 *
 */
@Repository
public interface OperatorRepository extends JpaRepository<Operator, Integer> {
	Operator findByOperatorId(Integer operatorId);

	Operator findByoperatorId(int operatorId);
	
	//Admin findByEmail(String email);

}