package com.codegram.cabapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codegram.cabapi.domain.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

	Driver findByDriverIdentifier(String driverIdentifier);

	//Driver findByDriverIdentifier(String driverId);
}