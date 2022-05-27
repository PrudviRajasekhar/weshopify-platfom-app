package com.weshopify.platform;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.weshopify.platform.features.customers.CustomerBean;
import com.weshopify.platform.features.customers.models.Customer;
import com.weshopify.platform.features.customers.repository.CustomerDataRepo;
import com.weshopify.platform.features.customers.service.CustomerService;

public class CustomerServiceTest extends WeShopifyPlatformApplicationTests {

	@Autowired
	private CustomerService customerService;
	CustomerBean customer = null;

	@BeforeEach
	public void init() {
		System.out.println("before each test case");
		customer = new CustomerBean();
		customer.setEmail("john@yopmail.com");
		customer.setFirstName("John");
		customer.setLastName("Peter");
		customer.setMobileNumber("9876543210");
		customer.setPassword("testUser@123");
		customer.setSelfReg(true);
		customer.setUserName("johnPeter");
	}

	@AfterEach
	public void destroy() {
		System.out.println("after each testcase");
		customer = null;
	}

	@Test
	@Order(value = 1)
	public void testSaveCustomer() {
		System.out.println("testSaveCustomer");
		customer = customerService.saveCustomer(customer);
		assertNotNull(customer);
		assertNotNull(customer.getCustomerId());
	}

	@Test
	@Order(value = 2)
	public void testUpdateCustomer() {
		System.out.println("testUpdateCustomer");
		String beforeUpdateEmail = customer.getEmail();
		customer.setEmail("johnPeter@yopmail.com");
		customer = customerService.updateCustomer(customer);
		assertNotNull(customer);
		assertNotNull(customer.getCustomerId());
		assertNotSame(beforeUpdateEmail, customer.getEmail());
		/*
		 * assertThatThrownBy(()->{ throw new RuntimeException();
		 * }).isInstanceOf(Exception.class) .hasMessage(message)
		 * 
		 * });
		 */
	}
}
