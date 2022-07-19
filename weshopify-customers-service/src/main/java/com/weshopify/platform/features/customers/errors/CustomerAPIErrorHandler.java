package com.weshopify.platform.features.customers.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@ControllerAdvice
@RestControllerAdvice
public class CustomerAPIErrorHandler {

	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<CustomerAPIError> handleCustomerNotFound(CustomerNotFoundException cne){
		CustomerAPIError apiError = new CustomerAPIError(HttpStatus.NOT_FOUND.value(),cne);
		return new ResponseEntity<CustomerAPIError>(apiError, HttpStatus.OK);
	}
	
	@ExceptionHandler(CustomerUpdateException.class)
	public ResponseEntity<CustomerAPIError> handleCustomerUpdateErrors(CustomerUpdateException cue){
		CustomerAPIError apiError = new CustomerAPIError(HttpStatus.BAD_REQUEST.value(),cue);
		return new ResponseEntity<CustomerAPIError>(apiError, HttpStatus.OK);
	}
}
