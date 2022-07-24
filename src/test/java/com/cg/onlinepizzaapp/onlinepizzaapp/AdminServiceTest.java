package com.cg.onlinepizzaapp.onlinepizzaapp;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cg.onlinepizzaapp.onlinepizzaapp.entity.Admin;
import com.cg.onlinepizzaapp.onlinepizzaapp.repository.IAdminRepository;
import com.cg.onlinepizzaapp.onlinepizzaapp.service.AdminServiceImpl;


@TestInstance(Lifecycle.PER_CLASS)

class AdminServiceTest {
	@InjectMocks
	AdminServiceImpl service;
	@Mock
	IAdminRepository dao;
	
	@BeforeAll
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	@Test
	void signIn() 
	{
		Admin admin= new Admin( "swagat","jena");
		when(dao.signIn("swagat","jena")).thenReturn(admin);
		Admin adchk= service.signIn("swagat","jena");
		assertEquals("swagat",adchk.getAdminName());
	}
	@Test
	void addNewAdmin()
	{
		Admin admin= new Admin( "admin","password");
		when(dao.save(admin)).thenReturn(admin);
		Admin chck= service.addNewAdmin(admin);
		assertEquals("admin",chck.getAdminName());
		assertNotEquals("Password",chck.getAdminPassword());
	}
	@Test
	void signOut() 
	{
		Admin admin= new Admin( "admin","pass");
		when(dao.save(admin)).thenReturn(admin);
		assertEquals("admin",dao.save(admin).getAdminName());
	}
	

}

