package com.cg.onlinepizzaapp.onlinepizzaapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import com.cg.onlinepizzaapp.onlinepizzaapp.entity.User;
import com.cg.onlinepizzaapp.onlinepizzaapp.repository.IUserRepository;
import com.cg.onlinepizzaapp.onlinepizzaapp.service.UserServiceImpl;

@TestInstance(Lifecycle.PER_CLASS)

class UserServiceTest {
	@InjectMocks
	UserServiceImpl service;
	@Mock
	IUserRepository dao;
	
	@BeforeAll
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	@Test
	void signIn() 
	{
		//Optional<User> user= Optional.of(new User("Swagat","Jena"));
		User user=new User("Swagat","Jena");
		when(dao.findByUserNameAndUserPassword("Swagat","Jena")).thenReturn(Optional.of(user));
		User usercheck=service.signIn("Swagat","Jena");
		assertEquals("Swagat",usercheck.getUserName());
	}
	@Test
	void addNewUser()
	{
		User user= new User("userName","password");
		when(dao.save(user)).thenReturn(user);
		User chck= service.addNewUser(user);
		assertEquals("userName",chck.getUserName());
		assertNotEquals("Password",chck.getUserPassword());
	}
	@Test
	void signOut() 
	{
		User user= new User("user","pasd");
		when(dao.save(user)).thenReturn(user);
		assertEquals("user",dao.save(user).getUserName());
	}
	

}
	