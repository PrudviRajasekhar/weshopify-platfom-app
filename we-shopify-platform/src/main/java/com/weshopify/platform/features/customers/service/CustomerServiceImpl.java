/**
 * 
 */
package com.weshopify.platform.features.customers.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.weshopify.platform.features.customers.CustomerBean;

/**
 * @author IM-LP-1763
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {
	
	private static Set<CustomerBean> IN_MEMORY_DB = new HashSet<CustomerBean>();

	@Override
	public CustomerBean saveCustomer(CustomerBean customerBean) {
		int customerId = new Random().nextInt();
		customerBean.setCustomerId(customerId);
		IN_MEMORY_DB.add(customerBean);
		return customerBean;
	}

	@Override
	public CustomerBean updateCustomer(CustomerBean customerBean) {
		IN_MEMORY_DB.add(customerBean);
		return customerBean;
	}

	@Override
	public List<CustomerBean> findAllCustomers() {
		// TODO Auto-generated method stub
		List<CustomerBean> customerList = new ArrayList<CustomerBean>(IN_MEMORY_DB);
		return customerList;
	}

	@Override
	public CustomerBean findCustomerById(int customerId) {
		List<CustomerBean> customerList = new ArrayList<CustomerBean>(IN_MEMORY_DB);
		return customerList.get(customerId);
	}

	@Override
	public List<CustomerBean> deleteCustomer(int customerId) {
		IN_MEMORY_DB.stream().forEach(customer->{
			if(customer.getCustomerId() == customerId) {
				IN_MEMORY_DB.remove(customer);
			}
		});
		List<CustomerBean> customerList = new ArrayList<CustomerBean>(IN_MEMORY_DB);
		return customerList;
	}

	@Override
	public List<CustomerBean> searchCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

}
