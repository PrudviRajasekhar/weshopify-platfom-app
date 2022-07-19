package com.weshopify.platform.features.customers.errors;

import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class CustomerAPIError {

	private String message;
	private int statusCode;
	private LocalDateTime timestamp;
	
	public CustomerAPIError() {
		super();
		this.timestamp = LocalDateTime.now();
	}
	
	public CustomerAPIError(int statusCode, Throwable tx) {
		this.message = tx.getMessage();
		this.statusCode = statusCode;
		this.timestamp = LocalDateTime.now();
		
	}
	
}
