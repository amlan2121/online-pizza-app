package com.cg.onlinepizzaapp.onlinepizzaapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlinepizzaapp.onlinepizzaapp.entity.Customer;



@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
	Optional<Customer> findBycustomerEmail(String customerEmail);
}