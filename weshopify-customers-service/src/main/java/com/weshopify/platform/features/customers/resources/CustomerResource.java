package com.weshopify.platform.features.customers.resources;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.weshopify.platform.features.customers.beans.CustomerBean;
import com.weshopify.platform.features.customers.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

//@RestController
@Controller
//@RequestMapping(value = "/api/v1")
@Slf4j
public class CustomerResource {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value = { "/customers" }, method = RequestMethod.GET)
	@Transactional(isolation = Isolation.READ_COMMITTED, 
					propagation =Propagation.REQUIRED, 
					rollbackFor = Throwable.class,
					timeout = 3,
					readOnly = true)
	 
	public  @ResponseBody List<CustomerBean> getAllCustomers() {
		log.info("in render signup page method");
		List<CustomerBean> customersList = customerService.findAllCustomers();
		return customersList;
	}
	
	@RequestMapping(value = { "/customers/{currentPage}/{NoOfRecPerPage}" }, method = RequestMethod.GET)
	public @ResponseBody List<CustomerBean> viewCustomersPageByPagination(@PathVariable("currentPage") int currentPage,
			@PathVariable("NoOfRecPerPage") int NoOfRecPerPage) {
		log.info("viewCustomersPageByPagination");
		
		List<CustomerBean> customersList = customerService.findAllCustomers(currentPage,NoOfRecPerPage);
		return customersList;
	}
	
	@RequestMapping(value = { "/customers/{customerId}" }, method = RequestMethod.DELETE)
	@Transactional(isolation = Isolation.READ_COMMITTED, 
	propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	public @ResponseBody List<CustomerBean> deleteCustomers(@PathVariable("customerId") int customerId) {
		
		log.info("deleteing the customet by the customer Id {}",customerId);
		List<CustomerBean> customersList = customerService.deleteCustomer(customerId);
		
		return customersList;
	}
	
	@RequestMapping(value = { "/customers/{customerId}" }, method = RequestMethod.GET)
	@Transactional(isolation = Isolation.READ_COMMITTED, 
	propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	public @ResponseBody CustomerBean findCustomersById(@PathVariable("customerId") int customerId) {
		
		log.info("deleteing the customet by the customer Id {}",customerId);
		CustomerBean customer = customerService.findCustomerById(customerId);
		
		return customer;
	}
	
	@RequestMapping(value = { "/customers" }, method = RequestMethod.POST)
	public @ResponseBody CustomerBean createCustomer(@RequestBody @Valid  CustomerBean customer, BindingResult validationResult) {
		List<String> errorList = new ArrayList<String>();
		log.info("is Customer Self Registered:\t"+customer.isSelfReg());
		log.info(customer.toString());
		
		/*
		 * if(validationResult.hasErrors()) {
		 * log.info("Data entered by Users contains the errors ");
		 * if(customer.isSelfReg()) { return "sign-up.html"; }else { return
		 * "customer-admin-reg.html"; }
		 * 
		 * }
		 */
		customer = customerService.saveCustomer(customer);
		return customer;
		
	}
	
	@RequestMapping(value = { "/customers" }, method = RequestMethod.PUT)
	public @ResponseBody CustomerBean updateCustomer(@Valid @RequestBody CustomerBean customer, BindingResult validationResult) {
		List<String> errorList = new ArrayList<String>();
		log.info("is Customer Self Registered:\t"+customer.isSelfReg());
		log.info(customer.toString());
		
		/*
		 * if(validationResult.hasErrors()) {
		 * log.info("Data entered by Users contains the errors ");
		 * if(customer.isSelfReg()) { return "sign-up.html"; }else { return
		 * "customer-admin-reg.html"; }
		 * 
		 * }
		 */
		customer = customerService.saveCustomer(customer);
		return customer;
		
	}
	
	@RequestMapping(value = { "/customers/{searchKey}/{searchText}" }, method = RequestMethod.POST)
	public @ResponseBody List<CustomerBean> searchCustomer(@PathVariable("searchKey") String searchKey, 
			@PathVariable("searchText") String searchText) {
		log.info("searchCustomer searchKey is:\t"+searchKey);
		log.info("searchCustomer searchText is:\t"+searchText);
		
		List<CustomerBean> customersList = customerService.seachAllCustomers(searchKey, searchText);
		
		return customersList;
		
	}

	
}
