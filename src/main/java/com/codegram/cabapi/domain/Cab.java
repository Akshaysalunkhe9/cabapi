package com.codegram.cabapi.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * entity for Cap
 * @author Abhijit 
 *
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Cab {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int cabId;
		private String carType;
		private float perKmRate;
		
		public Cab() {
			super();
		}
		
		public Cab(int cabId, String carType, float perKmRate) {
			super();
			this.cabId = cabId;
			this.carType = carType;
			this.perKmRate = perKmRate;
		}

		public int getCabId() {
			return cabId;
		}

		public void setCabId(int cabId) {
			this.cabId = cabId;
		}

		public String getCarType() {
			return carType;
		}

		public void setCarType(String carType) {
			this.carType = carType;
		}

		public float getPerKmRate() {
			return perKmRate;
		}

		public void setPerKmRate(float perKmRate) {
			this.perKmRate = perKmRate;
		}
		
		
}
