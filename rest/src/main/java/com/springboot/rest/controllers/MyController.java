package com.springboot.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.rest.Services.customerService;
import com.springboot.rest.entities.Customer;

@RestController
public class MyController {
	@Autowired
	private customerService CustomerService;
	
	@GetMapping("/home")
	public String welcome() {
		return "Welcome to Spring Boot Rest API";
	}
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getCustomers(@RequestParam(value="pageNumber",defaultValue="1",required=false) int pageNumber,
			@RequestParam(value="pageSize",defaultValue="10",required=false) int pageSize){

		List<Customer> allCust= this.CustomerService.getCustomers(pageNumber,pageSize);
		return new ResponseEntity<>(allCust,HttpStatus.OK);
		
	}
	@GetMapping("/customers/{id}")
	public Customer getCustomer(@PathVariable String id) {
		return this.CustomerService.getCustomer(Long.parseLong(id));
	}
	@PostMapping("/customer")
	public Customer addCustomer(@RequestBody Customer customer) {
		return this.CustomerService.addCustomer(customer);
	}
	@PutMapping("/customer")
	public Customer updateCustomer(@RequestBody Customer customer) {
		return this.CustomerService.updateCustomer(customer);
	}
	@DeleteMapping("/customer/{id}")
	public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable String id){
		try {
			this.CustomerService.deleteCustomer(Long.parseLong(id));
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception ex) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}