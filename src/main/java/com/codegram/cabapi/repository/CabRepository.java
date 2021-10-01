package com.codegram.cabapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codegram.cabapi.domain.Cab;

@Repository
public interface CabRepository extends  JpaRepository<Cab, Long> {

}
