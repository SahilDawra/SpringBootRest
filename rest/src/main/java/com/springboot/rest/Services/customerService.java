package com.springboot.rest.Services;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.springboot.rest.entities.Customer;

public interface customerService {
	
	public List<Customer> getCustomers(int pageNumber,int pageSize);
	public Customer getCustomer(long id);
	public Customer addCustomer(Customer customer);
	public Customer updateCustomer(Customer customer);
	public void deleteCustomer(long id);
}
