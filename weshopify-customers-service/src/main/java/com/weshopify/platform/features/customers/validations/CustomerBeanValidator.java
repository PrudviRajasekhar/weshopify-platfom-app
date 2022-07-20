package com.weshopify.platform.features.customers.validations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.weshopify.platform.features.customers.errors.CustomerAPIError;

//@RestControllerAdvice
public class CustomerBeanValidator extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		List<CustomerAPIError> listOfValidationErrors = new ArrayList<CustomerAPIError>();
		
		ex.getAllErrors().stream().forEach(objectError->{
			String validationMessage = objectError.getDefaultMessage();
			int statusCode = status.value();
			CustomerAPIError apiError = new CustomerAPIError(statusCode, validationMessage);
			listOfValidationErrors.add(apiError);
		});
		
		return new ResponseEntity<Object>(listOfValidationErrors, HttpStatus.BAD_REQUEST);
	}
	
}
