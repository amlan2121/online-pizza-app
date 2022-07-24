package com.cg.onlinepizzaapp.onlinepizzaapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cg.onlinepizzaapp.onlinepizzaapp.entity.Customer;
import com.cg.onlinepizzaapp.onlinepizzaapp.entity.User;
import com.cg.onlinepizzaapp.onlinepizzaapp.repository.ICustomerRepository;
import com.cg.onlinepizzaapp.onlinepizzaapp.service.CustomerServiceImpl;



@TestInstance(Lifecycle.PER_CLASS)
class CustomerServiceImplTest {

	@InjectMocks
	CustomerServiceImpl service;
	@Mock
	ICustomerRepository customerRepositry;
	
	
	
	@SuppressWarnings("deprecation")
	@BeforeAll
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
     void saveCustomerTest()//test the save customer method
	{
		User user= new User("ragav","ragav123");
		Customer cus = new Customer(user,"ragavan", 978589654L,"ragav@gmail.com","tirupur");
		when(customerRepositry.save(cus)).thenReturn(cus);
		assertEquals(cus,service.addCustomer(cus));
	}
	@Test
	void viewCustomerTest() {   //test the view customer method
		ArrayList<Customer> list=new ArrayList<>();
		User user1= new User("ragavan","ragavan123");
		Customer cus1 = new Customer(user1,"ragavan",978589654L,"ragavan@gmail.com","tirupur");
		User user2= new User("ragav","ragav123");
		Customer cus2 = new Customer(user2,"ragav",978589654L,"ragavanna@gmail.com","tirupur");
		User user3= new User("sri","sri123");
		Customer cus3 = new Customer(user3,"sri", 978589654L,"sri@gmail.com","tirupur");
		list.add(cus1);
		list.add(cus2);
		list.add(cus3);
		when(customerRepositry.findAll()).thenReturn(list);
		assertEquals(3, service.viewCustomer().size());
		
	}
	@Test
	void updateCustomerTest() { //test the update customer method
		User user1= new User("ragavan","ragavan123");
		Customer cus1 = new Customer(user1,"ragavan",978589654L,"ragavan@gmail.com","tirupur");
		cus1.setCustomerName("sri");
		when(customerRepositry.save(cus1)).thenReturn(cus1);
		assertEquals("sri",service.updateCustomer(cus1).getCustomerName());
		
	}
	@Test
	void viewByIdTest() {  //view the customer using id
		User user1= new User("ragavan","ragavan123");
		Optional<Customer> cus1 = Optional.of(new Customer(user1,"ragavan",9785896546L,"ragavan@gmail.com","tirupur"));
		when(customerRepositry.findById(1)).thenReturn(cus1);
		assertEquals("ragavan",service.viewCustomer(1).getCustomerName());
	}
	
}