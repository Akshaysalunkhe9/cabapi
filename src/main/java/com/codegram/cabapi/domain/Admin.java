package com.codegram.cabapi.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * This Admin class is a domain, which represents data and it will be moving
 * layer to layer.
 * 
 * @author aniket
 *
 */
@Entity
public class Admin  extends AbstractUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	/**
	 * name of the project
	 */

	public Admin() {

	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	
}