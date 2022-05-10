package com.weshopify.platform.features.customers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.weshopify.platform.features.customers.service.CustomerService;

@Controller
public class CustomerController {

	Logger log = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = { "/customer" }, method = RequestMethod.GET)
	public String renderSignupPage() {
		log.info("in render signup page method");
		return "sign-up.html";
	}
	
	@RequestMapping(value = { "/view-customers" }, method = RequestMethod.GET)
	public String viewCustomersPage() {
		log.info("in render signup page method");
		return "customer.html";
	}


	@RequestMapping(value = { "/customer" }, method = RequestMethod.POST)
	public String createCustomer(CustomerBean customer, Model model) {
		log.info("Customer Registration information is:\t");
		log.info(customer.toString());
		customer = customerService.saveCustomer(customer);
		if (customer.getCustomerId() > 0) {

			String message = "User Registration Successfull. Proceed with the Login Login";
			model.addAttribute("message", message);
		}
		return "sign-up.html";
	}

}
