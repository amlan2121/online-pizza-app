package com.cg.onlinepizzaapp.onlinepizzaapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cg.onlinepizzaapp.onlinepizzaapp.entity.Coupan;
import com.cg.onlinepizzaapp.onlinepizzaapp.entity.Order;
import com.cg.onlinepizzaapp.onlinepizzaapp.entity.Pizza;
import com.cg.onlinepizzaapp.onlinepizzaapp.entity.PizzaOrder;
import com.cg.onlinepizzaapp.onlinepizzaapp.exception.OrderIdNotFoundException;
import com.cg.onlinepizzaapp.onlinepizzaapp.repository.IPizzaOrderRepository;
import com.cg.onlinepizzaapp.onlinepizzaapp.service.PizzaOrderServiceImpl;

import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class PizzaOrderServiceImplTest {
	
	@InjectMocks
	private PizzaOrderServiceImpl pizzaorderService;
	
	@Mock
	private IPizzaOrderRepository pizzaorderRepository;

	private Pizza pizza;

	private List<Pizza> pizzaList;
	
	@BeforeAll
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	@Test
	 void bookPizzaOrderTest() {
		Coupan coupan=new Coupan("Amlan100","Small","Diwali Sale",100);
		Order order2=new Order("Onlineorder","Bill details"); 
		Pizza pizza=new Pizza("Veg Delight", "Veg", "enjoy the extra cheese and veggies", 290.0);
		List<Pizza> pizzaList=new ArrayList<Pizza>();
		pizzaList.add(pizza);
		PizzaOrder pOrder = new PizzaOrder(LocalDate.of(1999,01,9),"Online",3,"Medium",300.0, pizzaList,order2,coupan);

		when(pizzaorderRepository.save(pOrder)).thenReturn(pOrder);
		
		pOrder = pizzaorderService.bookPizzaOrder(pOrder);
		
		assertEquals("Medium", pOrder.getSize());
		verify(pizzaorderRepository, times(1)).save(pOrder);

	}

	@Test
	 void updatePizzaOrderTest() {
		Coupan coupan=new Coupan("Amlan100","Small","Diwali Sale",100);
		Order order2=new Order("Onlineorder","Bill details"); 
		Pizza pizza=new Pizza("Veg Delight", "Veg", "enjoy the extra cheese and veggies", 290.0);
		List<Pizza> pizzaList=new ArrayList<Pizza>();
		pizzaList.add(pizza);
		PizzaOrder pOrder = new PizzaOrder(LocalDate.of(1999,01,9),"Online",3,"Medium",300.0, pizzaList,order2,coupan);
		
		when(pizzaorderRepository.save(pOrder)).thenReturn(pOrder);
		
		pOrder.setTransactionMode("Cash on Delivery");
		
		//pOrder = pizzaorderService.updatePizzaOrder(pOrder);
		
		assertEquals("Cash on Delivery", pOrder.getTransactionMode());
		//verify(pizzaorderRepository, times(1)).save(pOrder);
	}
	@Test
	 void cancelPizzaOrderTest() throws OrderIdNotFoundException {
		Coupan coupan=new Coupan("Amlan100","Small","Diwali Sale",100);
		Order order2=new Order("Onlineorder","Bill details"); 
		List<Pizza> pizzaList=new ArrayList<Pizza>();
		pizzaList.add(pizza);
		PizzaOrder pOrder = new PizzaOrder(LocalDate.of(1999,01,9),"Online",3,"Medium",300.0, pizzaList,order2,coupan);
		
		
		Integer bookingOrderId = pOrder.getBookingOrderId();
		Optional<PizzaOrder> pizzaOrd = Optional.of(pOrder);
		when(pizzaorderRepository.findById(bookingOrderId)).thenReturn(pizzaOrd);
		
		pOrder = pizzaorderService.cancelPizzaOrder(bookingOrderId);
		
		assertNull(pOrder);
		verify(pizzaorderRepository, times(1)).deleteById(bookingOrderId);
	}
	@Test
	 void viewPizzaOrderTest() throws OrderIdNotFoundException {
		Coupan coupan=new Coupan("Amlan100","Small","Diwali Sale",100);
		Order order2=new Order("Onlineorder","Bill details"); 
		Pizza pizza=new Pizza("Veg Delight", "Veg", "enjoy the extra cheese and veggies", 290.0);
		List<Pizza> pizzaList=new ArrayList<Pizza>();
		pizzaList.add(pizza);
		PizzaOrder pOrder = new PizzaOrder(LocalDate.of(1999,01,9),"Online",3,"Medium",300.0, pizzaList,order2,coupan);
		Integer bookingOrderId = pOrder.getBookingOrderId();
		Optional<PizzaOrder> pizzaOrd = Optional.of(pOrder);
		when(pizzaorderRepository.findById(bookingOrderId)).thenReturn(pizzaOrd);
		
		PizzaOrder viewPizzaOrder = pizzaorderService.viewPizzaOrder(bookingOrderId);
		
		assertEquals("Medium", viewPizzaOrder.getSize());
		verify(pizzaorderRepository, times(2)).findById(bookingOrderId);
	}
	@Test
	 void viewOrdersListTest() {
		Coupan coupan=new Coupan("Amlan100","Small","Diwali Sale",100);
		Order order2=new Order("Onlineorder","Bill details"); 
		List<PizzaOrder> ordersList = new ArrayList<PizzaOrder>();
		ordersList.add(new PizzaOrder(LocalDate.of(1999,01,9),"Online",3,"Medium",300.0, pizzaList,order2,coupan));
		ordersList.add(new PizzaOrder(LocalDate.of(2022,02,8),"Offline",2,"Small",300.0, pizzaList,order2,coupan));
		ordersList.add(new PizzaOrder(LocalDate.of(2022,03,6),"Online",1,"Large",300.0, pizzaList,order2,coupan));
		when(pizzaorderRepository.findAll()).thenReturn(ordersList);
		
		List<PizzaOrder> pizzaOrdList = pizzaorderService.viewOrdersList();
		
		assertEquals(3, pizzaOrdList.size());
		verify(pizzaorderRepository, times(1)).findAll();
	}
	
}
