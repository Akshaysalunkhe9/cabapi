package com.codegram.cabapi.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * @author anand
 *
 */
@Entity
public class Operator  extends AbstractUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer operatorId;
	/**
	 * name for the project
	 */

	public Operator() {
		super();
	}

	public Integer getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(Integer operatorId) {
		this.operatorId = operatorId;
	}

	public Operator(Integer operatorId) {
		super();
		this.operatorId = operatorId;
	}
}