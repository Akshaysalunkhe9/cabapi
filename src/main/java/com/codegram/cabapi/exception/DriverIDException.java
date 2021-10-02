package com.codegram.cabapi.exception;

	import org.springframework.http.HttpStatus;
	import org.springframework.web.bind.annotation.ResponseStatus;
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public class DriverIDException extends RuntimeException {
		
		private static final long serialVersionUID = 1L;

		/**
		 * This will create ProjectIDException object without error message
		 */
		public DriverIDException() {
			super();
		}

		/**
		 * This will create ProjectIDException object with error message
		 */
		public DriverIDException(String msg) {
			super(msg);
		}

}
