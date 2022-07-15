package com.cg.onlinepizzaapp.onlinepizzaapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.HttpMediaTypeNotSupportedException;

import com.cg.onlinepizzaapp.onlinepizzaapp.entity.Customer;
import com.cg.onlinepizzaapp.onlinepizzaapp.service.ICustomerService;


@CrossOrigin(origins ="*")
@RestController
public class CustomerController {
	@Autowired
	private ICustomerService custService;
	
	@PostMapping("/saveCustomer")
	public Customer addCustomer(@RequestBody Customer customer) {
		return custService.addCustomer(customer);
	}
	
	@PutMapping("/updateCustomer")
	public Customer updateCustomer(@RequestBody Customer customer) {
		return custService.updateCustomer(customer);
	}
	
	@DeleteMapping("/deleteCustomer/{customerId}")
	public Customer deleteCustomer(@PathVariable("customerId") Integer customerId) {
		return custService.deleteCustomer(customerId);
	}
	
	@GetMapping("/viewCustomer")
	public List<Customer> viewCustomer() {
		return custService.viewCustomer();
	}
	
	@GetMapping("/viewCustomer/{customerId}")
	public Customer viewCustomer(@PathVariable("customerId") Integer customerId ) {
		return custService.viewCustomer(customerId);
	}
}
