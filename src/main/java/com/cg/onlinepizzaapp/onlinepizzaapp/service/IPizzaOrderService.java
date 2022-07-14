package com.cg.onlinepizzaapp.onlinepizzaapp.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.onlinepizzaapp.onlinepizzaapp.entity.PizzaOrder;

public interface IPizzaOrderService {
	public PizzaOrder bookPizzaOrder(PizzaOrder order);
	public PizzaOrder updatePizzaOrder(PizzaOrder order);
	public PizzaOrder cancelPizzaOrder(Integer bookingOrderId);
	public PizzaOrder viewPizzaOrder(Integer bookingOrderId);
	public List<PizzaOrder> viewOrdersList();
	public List<PizzaOrder> viewOrdersList(LocalDate date);
	public List<PizzaOrder> calculateTotal(String size,Integer quantity);
}
