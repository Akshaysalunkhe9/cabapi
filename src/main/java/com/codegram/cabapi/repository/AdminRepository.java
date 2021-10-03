package com.codegram.cabapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codegram.cabapi.domain.Admin;


/**
 * @author Aniket
 *
 */
@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
	Admin findByAdminId(Integer adminId);

	Admin findByadminId(int adminId);
	
	Admin findByEmail(String email);

}





