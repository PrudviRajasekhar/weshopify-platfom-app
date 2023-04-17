package com.weshopify.platform.features.customers.errors;

import lombok.Getter;

@Getter
public class CustomerUpdateException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;
	private String statusCode;
	
	public CustomerUpdateException() {
		super();
	}
	
	public CustomerUpdateException(String message){
		 this.message=message;
		 //this.statusCode=statusCode;
	}

}
