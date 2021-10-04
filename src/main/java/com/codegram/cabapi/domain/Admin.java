package com.codegram.cabapi.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * This Project Admin is a domain, which represents data and it will be moving
 * layer to layer.
 * 
 * @author aniket
 *
 */
@Entity
public class Admin  extends AbstractUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long adminId;
	/**
	 * name for the project
	 */

	public Admin() {

	}

	public long getAdminId() {
		return adminId;
	}

	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}

	public Admin(long adminId) {
		super();
		this.adminId = adminId;
	}
}