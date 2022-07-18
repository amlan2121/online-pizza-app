package com.cg.onlinepizzaapp.onlinepizzaapp.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.onlinepizzaapp.onlinepizzaapp.entity.PizzaOrder;
import com.cg.onlinepizzaapp.onlinepizzaapp.exception.OrderIdNotFoundException;

public interface IPizzaOrderService {
	public PizzaOrder bookPizzaOrder(PizzaOrder order);
	public PizzaOrder updatePizzaOrder(PizzaOrder order) throws OrderIdNotFoundException;
	public PizzaOrder cancelPizzaOrder(Integer bookingOrderId) throws OrderIdNotFoundException;
	public PizzaOrder viewPizzaOrder(Integer bookingOrderId) throws OrderIdNotFoundException;
	public List<PizzaOrder> viewOrdersList() throws OrderIdNotFoundException;
	public List<PizzaOrder> viewOrdersList(LocalDate date);
	//public PizzaOrder calculateTotal(PizzaOrder order);
	public String calculateTotal(String size, double quantity);
}
