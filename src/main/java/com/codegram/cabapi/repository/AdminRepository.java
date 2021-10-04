package com.codegram.cabapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codegram.cabapi.domain.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
	Admin findByAdminId(Long adminId);
}
