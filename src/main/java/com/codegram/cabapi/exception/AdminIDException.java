package com.codegram.cabapi.exception;

	import org.springframework.http.HttpStatus;
	import org.springframework.web.bind.annotation.ResponseStatus;
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public class AdminIDException extends RuntimeException {
		
		private static final Long serialVersionUID = 1L;

		/**
		 * This will create AdminIDException object without error message
		 */
		public AdminIDException() {
			super();
		}

		/**
		 * This will create AdminIDException object with error message
		 */
		public AdminIDException(String msg) {
			super(msg);
		}

}
	
	
	
	
	