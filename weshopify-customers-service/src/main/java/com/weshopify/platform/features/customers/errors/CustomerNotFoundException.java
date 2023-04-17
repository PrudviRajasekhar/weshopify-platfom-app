package com.weshopify.platform.features.customers.errors;

import lombok.Getter;

@Getter
public class CustomerNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;
	//private String statusCode;
	
	public CustomerNotFoundException() {
		super();
	}
	
	public CustomerNotFoundException(String message){
		 this.message=message;
		 //this.statusCode=statusCode;
	}

}
