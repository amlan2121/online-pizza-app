package com.cg.onlinepizzaapp.onlinepizzaapp.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.cg.onlinepizzaapp.onlinepizzaapp.entity.Customer;

@Service
public interface ICustomerService {
	
	 public Customer addCustomer(Customer customer);  
	 public Customer updateCustomer(Customer customer);
     public Customer deleteCustomer(Integer customerId);
     public List<Customer> viewCustomer();
     public Customer viewCustomer(Integer customerId);
}