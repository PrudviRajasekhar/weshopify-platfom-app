package com.weshopify.platform.features.customers.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerServicesUtil {
	
	private static final Logger log = LoggerFactory.getLogger(CustomerServicesUtil.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${email.domain.validate.api}")
	private String emailValidateApi;
	
	@Value("${email.domain.validate.api.key}")
	private String emailValidateApiKey;
	
	@Value("${email.domain.validate.api.value}")
	private String emailValidateApiValue;
	
	@Value("${email.domain.validate.host.name}")
	private String emailValidateHostName;
	
	@Value("${email.domain.validate.host.value}")
	private String emailValidateHostValue;
	
	
	public boolean isValidEmailDomina(String email) {
		boolean isValidEmailDomain = false;
		
		log.info("email API Is:\t,{}",emailValidateApi);
		log.info("email host is:\t,{},{}",emailValidateHostName,emailValidateHostValue);
		log.info("email API key is:\t{},{}",emailValidateApiKey,emailValidateApiValue);
		
		/*
		 * HttpHeaders headers = new HttpHeaders(); headers.set(emailValidateHostName,
		 * emailValidateHostValue); headers.set(emailValidateApiKey,
		 * emailValidateApiValue);
		 */		
		Map<String,String> headers = new HashMap<>();
		headers.put(emailValidateHostName, emailValidateHostValue);
		headers.put(emailValidateApiKey, emailValidateApiValue);
		
		emailValidateApi = emailValidateApi+"?email="+email+
				"&opt=VerifyMailbox:Express|VerifyMailbox:ExpressPremium&format=json";
		HttpEntity entity = new HttpEntity<>(headers);
		
		ResponseEntity<String> respEntity = restTemplate.getForEntity(emailValidateApi, String.class, headers);
		if(respEntity.getStatusCodeValue()==HttpStatus.OK.value()) {
			isValidEmailDomain =true;			
		}
		
		log.info("Is Valid Email Domain:\t {}",isValidEmailDomain);
		return isValidEmailDomain;
	}
}
