package com.cg.onlinepizzaapp.onlinepizzaapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinepizzaapp.onlinepizzaapp.entity.Customer;
import com.cg.onlinepizzaapp.onlinepizzaapp.exception.CustomerAlreadyPresentException;
import com.cg.onlinepizzaapp.onlinepizzaapp.exception.CustomerIdNotFoundException;
import com.cg.onlinepizzaapp.onlinepizzaapp.repository.ICustomerRepository;

@Service
public class CustomerServiceImpl implements ICustomerService{
	
	@Autowired
	private ICustomerRepository custRepo;
	
	

	@Override
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Optional<Customer> cust = custRepo.findById(customer.getCustomerId());
		if(cust.isPresent()) {
			throw new CustomerAlreadyPresentException("Customer with mobile number " + customer.getCustomerId() + " is already registered");
		}
		else {
			return custRepo.save(customer);
		}	
	}
	

	@Override
	public Customer updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Optional<Customer> cust = custRepo.findById(customer.getCustomerId());
		
		if(cust.isPresent()) {
			return custRepo.save(customer);
		}
		else {
			return addCustomer(customer);
		}
	}

	@Override
	public Customer deleteCustomer(Integer customerId) {
		// TODO Auto-generated method stub
		Optional<Customer> cust = custRepo.findById(customerId);
		if(cust.isPresent()) {
			custRepo.deleteById(customerId);
			return cust.get();
		}
		else {
			throw new CustomerIdNotFoundException("Customer id is not available");
		}
	}

	@Override
	public List<Customer> viewCustomer() {
		// TODO Auto-generated method stub
		List<Customer> list = new ArrayList<>();
		custRepo.findAll().forEach(list::add);
		return list;
	}

	@Override
	public Customer viewCustomer(Integer customerId) {
		// TODO Auto-generated method stub
		Optional<Customer> cust = custRepo.findById(customerId);
		if (cust.isPresent()) {
			return cust.get();

		} else {
			throw new CustomerIdNotFoundException("Customer id is not available");
		}
	}

}