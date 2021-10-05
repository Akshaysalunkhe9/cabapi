package com.codegram.cabapi.exception;

	import org.springframework.http.HttpStatus;
	import org.springframework.web.bind.annotation.ResponseStatus;
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public class OperatorIDException extends RuntimeException {
		
		private static final Long serialVersionUID = 1L;

		/**
		 * This will create AdminIDException object without error message
		 */
		public OperatorIDException() {
			super();
		}

		/**
		 * This will create AdminIDException object with error message
		 */
		public OperatorIDException(String msg) {
			super(msg);
		}

}