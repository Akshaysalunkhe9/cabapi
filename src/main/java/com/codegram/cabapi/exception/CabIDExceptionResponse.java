package com.codegram.cabapi.exception;

public class CabIDExceptionResponse {

		String id;

		public CabIDExceptionResponse(String id) {
			super();
			this.id = id;
		}

		public String id() {
			return id;
		}

		public void setcabId(String id) {
			this.id = id;
		}
		
}