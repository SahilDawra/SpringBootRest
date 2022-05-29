package com.springboot.rest.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springboot.rest.dao.customerDao;
import com.springboot.rest.entities.Customer;
@Service
public class CustomerServiceImpl implements customerService  {
	@Autowired
	private customerDao CustomerDao;
	
	@Override
	public List<Customer> getCustomers(int pageNumber, int pageSize) {
		Pageable p=PageRequest.of(pageNumber, pageSize);
		Page<Customer> customerPage= CustomerDao.findAll(p);
		return customerPage.getContent();
	}

	@Override
	public Customer getCustomer(long id) {
		return CustomerDao.findById(id).get();
	}

	@Override
	public Customer addCustomer(Customer customer) {
		CustomerDao.save(customer);
		return customer;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		CustomerDao.save(customer);
		return customer;
	}

	@Override
	public void deleteCustomer(long id) {
		Customer customer= CustomerDao.getOne(id);
		CustomerDao.delete(customer);
	}
}
