package com.springboot.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.rest.entities.Customer;

public interface customerDao extends JpaRepository<Customer,Long> {
	
}
