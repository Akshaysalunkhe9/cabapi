package com.codegram.cabapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codegram.cabapi.domain.Cab;

@Repository
public interface CabRepository extends JpaRepository<Cab, Integer> {
	Cab findByCabId(int cabId);
	//Cab findByCarType(String carType);
}