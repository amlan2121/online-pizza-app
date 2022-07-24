package com.cg.onlinepizzaapp.onlinepizzaapp.controller;

import java.time.LocalDate;
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

import com.cg.onlinepizzaapp.onlinepizzaapp.entity.PizzaOrder;
import com.cg.onlinepizzaapp.onlinepizzaapp.exception.OrderIdNotFoundException;
import com.cg.onlinepizzaapp.onlinepizzaapp.service.IPizzaOrderService;


@CrossOrigin(origins="*")
@RestController
public class PizzaOrderController {
	
	@Autowired
	public IPizzaOrderService service;
	
	
	@PostMapping("/bookpizzaorder")
	public PizzaOrder bookPizzaOrder(@RequestBody PizzaOrder order)
	
	{
		return service.bookPizzaOrder(order);
		
	}
	
	@PutMapping("/updatepizzaorder")
	public PizzaOrder updatePizzaOrder(PizzaOrder order) throws OrderIdNotFoundException
	{
		return service.updatePizzaOrder(order);
		
	}
	
	@DeleteMapping("/cancelpizzaorder/{bookingOrderId}")
	public PizzaOrder cancelPizzaOrder(@PathVariable("bookingOrderId") Integer bookingOrderId) throws OrderIdNotFoundException
	{
		return service.cancelPizzaOrder(bookingOrderId);
		
	}
	
	@GetMapping("/vieworderlist")
	public List<PizzaOrder> viewOrdersList() throws OrderIdNotFoundException
	{
		return service.viewOrdersList();
	}
	
	@GetMapping("/vieworderlist/{bookingOrderId}")
	public PizzaOrder viewPizzaOrder(@PathVariable("bookingOrderId") Integer bookingOrderId) throws OrderIdNotFoundException
	{
		return service.viewPizzaOrder(bookingOrderId);
	}
	
	@GetMapping("/vieworderlist/date/{date}")
	public List<PizzaOrder> viewPizzaOrder(LocalDate date) throws OrderIdNotFoundException
	{
		return service.viewOrdersList(date);
	}
	

	
	@GetMapping("/pizzaorder/calculatetotal")
	public Double calculateTotal(PizzaOrder order) {
		return service.calculateTotal(order);
	}
	


}