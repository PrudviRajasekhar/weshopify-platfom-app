package com.weshopify.ecomm.service;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.weshopify.ecomm.beans.Customer;
import com.weshopify.ecomm.config.AppConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class,
loader = AnnotationConfigContextLoader.class)
public class CustomerTest {
	
	@Autowired
	private Customer customer;
	
	@Test
	public void testGetCustomerDetails() {
		Map<String, String> customerDetails = customer.getCustomerDetails();
		for(String key: customerDetails.keySet()) {
			System.out.println(customerDetails.get(key));
		}
	}
}
