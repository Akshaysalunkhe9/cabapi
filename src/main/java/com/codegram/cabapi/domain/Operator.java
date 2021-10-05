package com.codegram.cabapi.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * This Operator Class is a domain, which represents data and it will be moving
 * layer to layer.
 * 
 * @author anand
 *
 */
@Entity
public class Operator  extends AbstractUser {
	/**
	 * id of the opertor  and auto generated
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	/**
	 * name for the project
	 */

	public Operator() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	

}