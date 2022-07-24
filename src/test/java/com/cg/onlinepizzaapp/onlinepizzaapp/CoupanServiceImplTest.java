package com.cg.onlinepizzaapp.onlinepizzaapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cg.onlinepizzaapp.onlinepizzaapp.entity.Coupan;
import com.cg.onlinepizzaapp.onlinepizzaapp.exception.CoupanIdNotFoundException;
import com.cg.onlinepizzaapp.onlinepizzaapp.exception.InvalidCoupanOperationException;
import com.cg.onlinepizzaapp.onlinepizzaapp.repository.ICoupanRepository;
import com.cg.onlinepizzaapp.onlinepizzaapp.service.CoupanServiceImpl;

@TestInstance(Lifecycle.PER_CLASS)
public class CoupanServiceImplTest {
	
	@InjectMocks
	CoupanServiceImpl service;
	
	@Mock
	ICoupanRepository dao;
	
	
	@BeforeAll
	public void init(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	void viewAllCoupantest() throws CoupanIdNotFoundException
	{
		List<Coupan> list= new ArrayList<Coupan>();
		Coupan c1=new Coupan("Amlan100","Small","Diwali Sale",100);
		Coupan c2=new Coupan("Swagat50","Medium","Holi Sale",50);
		Coupan c3=new Coupan("Priya200","Large","Diwali Sale",200);
		Coupan c4=new Coupan("Abhi500","Medium","Diwali Sale",300);
		Coupan c5=new Coupan("Jod40","Small","friday",40);
		list.add(c1);
		list.add(c2);
		list.add(c3);
		list.add(c4);
		list.add(c5);
		when(dao.findAll()).thenReturn(list);
		List<Coupan> coulist=service.viewCoupans();
		
		
	}
	@Test
	void addCoupanTest() 
	{
		Coupan c1=new Coupan("Amlan100","Small","Diwali Sale",100);
		when(dao.save(c1)).thenReturn(c1);
		Coupan addcheck=service.addCoupans(c1);
		assertEquals("Amlan100",addcheck.getCoupanName());
		assertEquals("Small",addcheck.getCoupanType());
		assertEquals("Diwali Sale",addcheck.getCoupanDescription());
		assertEquals(100,addcheck.getCoupanCost());
		
			
	}
	
	@Test
	void updateCoupanTest() throws InvalidCoupanOperationException
	{
		Coupan c1=new Coupan("Amlan100","Small","Diwali Sale",150);
		when(dao.save(c1)).thenReturn(c1);
		Coupan updcheck=service.editCoupans(c1);
		assertEquals("Amlan100",updcheck.getCoupanName());
		assertEquals("Small",updcheck.getCoupanType());
		assertEquals("Diwali Sale",updcheck.getCoupanDescription());
		assertEquals(150,updcheck.getCoupanCost());	
		
	}
	
	@Test 
	void testCoupanIdNotFoundException()
	{
		Assertions.assertThrows(CoupanIdNotFoundException.class,()->{service.viewCoupanByName("Amitabh");});
	}
	
	
	

}