/**
 * 
 */
package com.weshopify.platform.features.customers.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.weshopify.platform.features.customers.CustomerBean;
import com.weshopify.platform.features.customers.models.Customer;
import com.weshopify.platform.features.customers.repository.CustomerDataRepo;

/**
 * @author IM-LP-1763
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {
	
	//private static Set<CustomerBean> IN_MEMORY_DB = new HashSet<CustomerBean>();
	private static Map<Integer, CustomerBean> IN_MEMORY_DB = new HashMap<Integer, CustomerBean>();
	
	
	private CustomerDataRepo customerRepo;
     
	@Autowired
	public CustomerServiceImpl(CustomerDataRepo customerRepo) {
		this.customerRepo=customerRepo;
	}
	/**
	 * if the id is there in the customer bean
	 * then update the database with the data that is coming inside
	 * the customer bean else save it as new customer
	 */
	@Override
	public CustomerBean saveCustomer(CustomerBean customerBean) {
		
		/*
		 * if(customerBean.getCustomerId() != 0) {
		 * IN_MEMORY_DB.put(customerBean.getCustomerId(),customerBean); }else { int
		 * customerId = new Random().nextInt(); customerBean.setCustomerId(customerId);
		 * IN_MEMORY_DB.put(customerId,customerBean); }
		 */
		/**
		 * Step-1: Convert the bean data to domain to save in database
		 */
		Customer customerDomain = new Customer();
		BeanUtils.copyProperties(customerBean, customerDomain);
		customerRepo.save(customerDomain);
		
		/**
		 * Step-2: Convert the domain data to bean again beacuse domain might have 
		 * the auto generated ID to set it back to the bean to send it again for the 
		 * futher CRD operations
		 */
		customerBean.setCustomerId(customerDomain.getCustomerId());
		BeanUtils.copyProperties(customerDomain, customerBean);
		return customerBean;
	}

	@Override
	public CustomerBean updateCustomer(CustomerBean customerBean) {
		//IN_MEMORY_DB.put(customerBean.getCustomerId(),customerBean);
		if(customerBean.getCustomerId() > 0) {
			return saveCustomer(customerBean);
		}else {
			throw new RuntimeException("Updating Customer applied on existing customers only");
		}
		
	}

	@Override
	public List<CustomerBean> findAllCustomers() {
		// TODO Auto-generated method stub
		List<CustomerBean> customerList = new ArrayList<>();
		Iterable<Customer> customerIterator = customerRepo.findAll();
		
		customerIterator.forEach(customer->{
			CustomerBean customerBean = new CustomerBean();
			BeanUtils.copyProperties(customer, customerBean);
			customerList.add(customerBean);
			
		});
		return customerList;
	}

	@Override
	public CustomerBean findCustomerById(int customerId) {
		Optional<Customer> opt = customerRepo.findById(customerId);
		CustomerBean customerBean = new CustomerBean();
		opt.ifPresentOrElse(
				(customer)->{
					
					BeanUtils.copyProperties(customer, customerBean);
				}, 
				
				()->{
					throw new RuntimeException("No Customer Found with the CustomerId:\t"+customerId);
				});
		
		return customerBean;
		
	}

	@Override
	public List<CustomerBean> deleteCustomer(int customerId) {
		IN_MEMORY_DB.remove(customerId);
		customerRepo.deleteById(customerId);
		//List<CustomerBean> customerList = new ArrayList<CustomerBean>(IN_MEMORY_DB.values());
		return findAllCustomers();
	}

	@Override
	public List<CustomerBean> searchCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

}
