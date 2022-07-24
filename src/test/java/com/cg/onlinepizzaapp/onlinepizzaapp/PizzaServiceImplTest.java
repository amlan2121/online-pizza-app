package com.cg.onlinepizzaapp.onlinepizzaapp;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cg.onlinepizzaapp.onlinepizzaapp.entity.Pizza;
import com.cg.onlinepizzaapp.onlinepizzaapp.exception.PizzaIdNotFoundException;
import com.cg.onlinepizzaapp.onlinepizzaapp.repository.IPizzaRepository;
import com.cg.onlinepizzaapp.onlinepizzaapp.service.PizzaServiceImpl;


@TestInstance(Lifecycle.PER_CLASS)
class PizzaServiceImplTest {
	@InjectMocks
	PizzaServiceImpl service;
	@Mock
	IPizzaRepository dao;

	@BeforeAll
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void viewAllPizzatest() {
		List<Pizza> list = new ArrayList<Pizza>();
		Pizza p1 = new Pizza("Doublecheese", "Veg", "enjoy the extra cheese", 250.0);
		Pizza p2 = new Pizza("Cheese", "Veg","enjoy the flavours of veggies", 350.0);
		Pizza p3 = new Pizza( "ClassicCheese", "Veg","enjoy classical flavour of cheese", 150.0);
		Pizza p4 = new Pizza("Double cheese chicken", "Non-Veg","enjoy double cheese nonveg", 350.0);
		Pizza p5 = new Pizza("Barbeque Chicken", "Non-Veg","enjoy cheese and barbeque", 450.0);
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		list.add(p5);
		when(dao.findAll()).thenReturn(list);
		List<Pizza> pizzlist = service.viewPizzaList();
		assertEquals(5, pizzlist.size());
	//	verify(dao, times(2)).findAll();
	}

	@Test
	void addPizzaTest() {
		Pizza p1 = new Pizza("Doublecheese", "Veg", "enjoy the extra cheese", 250.0);
		when(dao.save(p1)).thenReturn(p1);
		Pizza addchk = service.addPizza(p1);
		assertEquals("Veg", addchk.getPizzaType());
		assertEquals("Doublecheese", addchk.getPizzaName());
	}

	@Test
	void updatePizzaTest() {
		Pizza p1 = new Pizza("Doublecheese", "Veg","enjoy the extra cheese with double taste",260.0);
		when(dao.save(p1)).thenReturn(p1);
		Pizza upd = service.updatePizza(p1);
		assertEquals("Veg", upd.getPizzaType());
		assertEquals("Doublecheese", upd.getPizzaName());
	}

	@Test
	void pizzaByTypeTest() {
		List<Pizza> list = new ArrayList<Pizza>();
		List<Pizza> pizz = new ArrayList<Pizza>();
		Pizza p1 = new Pizza("Doublecheese", "Veg", "enjoy the extra cheese", 250.0);
		Pizza p2 = new Pizza("Cheese", "Veg","enjoy the flavours of veggies", 350.0);
		Pizza p3 = new Pizza( "ClassicCheese", "Veg","enjoy classical flavour of cheese", 150.0);
		Pizza p4 = new Pizza("Double cheese chicken", "Non-Veg","enjoy double cheese nonveg", 350.0);
		Pizza p5 = new Pizza("Doublecheese", "Veg","enjoy the extra cheese", 450.0);
		Pizza p6 = new Pizza("ClassicCheese", "Veg","enjoy classical flavour of cheese", 150.0);
		Pizza p7 = new Pizza( "Double cheese chicken", "Non-Veg","enjoy double cheese nonveg", 350.0);
		Pizza p8 = new Pizza( "Doublecheese", "Veg", "enjoy the extra cheese", 450.0);
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		list.add(p5);
		pizz.add(p6);
		pizz.add(p7);
		pizz.add(p8);
		when(dao.findBypizzaTypeEquals("Veg")).thenReturn(pizz);
		List<Pizza> pizzlist = service.viewPizzaList("Veg");

		assertEquals(3, pizzlist.size());
	}

	@Test
	void findPizzaTest() throws PizzaIdNotFoundException {
		Optional<Pizza> p1 = Optional.of(new Pizza("Doublecheese", "Veg", "enjoy the extra cheese", 250.0));
		when(dao.findById(1)).thenReturn(p1);
		Pizza pizz = service.viewPizza(1);
	
		assertEquals("Veg", pizz.getPizzaType());
	}
}
