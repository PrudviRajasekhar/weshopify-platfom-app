package com.weshopify.platform.features.customers.repository;

import org.springframework.data.repository.CrudRepository;

import com.weshopify.platform.features.customers.models.Customer;

public interface CustomerDataRepo extends CrudRepository<Customer, Integer> {

}
