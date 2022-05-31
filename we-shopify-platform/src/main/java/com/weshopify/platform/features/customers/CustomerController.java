package com.weshopify.platform.features.customers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.weshopify.platform.features.customers.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class CustomerController {

	//Logger log = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = { "/customer" }, method = RequestMethod.GET)
	public String customerSelfSignupPage() {
		log.info("in render signup page method");
		return "sign-up.html";
	}
	
	@RequestMapping(value = { "/customer-admin-reg" }, method = RequestMethod.GET)
	public String customerAdminSignupPage(Model model) {
		log.info("in customer-admin-reg");
		model.addAttribute("customer", new CustomerBean());
		return "customer-admin-reg.html";
	}
	
	@RequestMapping(value = { "/view-customers" }, method = RequestMethod.GET)
	public String viewCustomersPage(Model model) {
		log.info("in render signup page method");
		List<CustomerBean> customersList = customerService.findAllCustomers();
		model.addAttribute("customersList", customersList);
		return "customer.html";
	}
	
	@RequestMapping(value = { "/view-customers/{currentPage}/{NoOfRecPerPage}" }, method = RequestMethod.GET)
	public String viewCustomersPageByPagination(Model model,@PathVariable("currentPage") int currentPage,
			@PathVariable("NoOfRecPerPage") int NoOfRecPerPage) {
		log.info("viewCustomersPageByPagination");
		
		List<CustomerBean> customersList = customerService.findAllCustomers(currentPage,NoOfRecPerPage);
		model.addAttribute("customersList", customersList);
		return "customer.html";
	}
	
	@RequestMapping(value = { "/delete-customers/{customerId}" }, method = RequestMethod.GET)
	public String deleteCustomers(@PathVariable("customerId") int customerId, Model model) {
		
		log.info("deleteing the customet by the customer Id {}",customerId);
		
		List<CustomerBean> customersList = customerService.deleteCustomer(customerId);
		model.addAttribute("customersList", customersList);
		return "customer.html";
	}


	@RequestMapping(value = { "/customer" }, method = RequestMethod.POST)
	public String createCustomer(@ModelAttribute("customer") @Valid CustomerBean customer, BindingResult validationResult,Model model) {
		List<String> errorList = new ArrayList<String>();
		log.info("is Customer Self Registered:\t"+customer.isSelfReg());
		log.info(customer.toString());
		
		if(validationResult.hasErrors()) {
			log.info("Data entered by Users contains the errors ");
			if(customer.isSelfReg()) {
				return "sign-up.html";
			}else {
				return "customer-admin-reg.html";
			}
			
		}
		customer = customerService.saveCustomer(customer);
		if (customer.getCustomerId() > 0) {

			String message = "User Registration Successfull. Proceed with the Login Login";
			model.addAttribute("message", message);
		}
		if(customer.isSelfReg()) {
			return "sign-up.html";
		}else {
			return "redirect:/view-customers";
		}
		
	}
	
	@RequestMapping(value = { "/edit-customers/{customerId}" }, method = RequestMethod.GET)
	public String editCustomer(@PathVariable("customerId") int customerId, Model model) {
		log.info("customer ID in Edit Customer Page:\t"+customerId);
		CustomerBean customer = customerService.findCustomerById(customerId);
		model.addAttribute("customer",customer);
		return "customer-admin-reg.html";
		
	}

}
