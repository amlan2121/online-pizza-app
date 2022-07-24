package com.cg.onlinepizzaapp.onlinepizzaapp.service;

import java.time.LocalDate;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.cg.onlinepizzaapp.onlinepizzaapp.entity.Pizza;
import com.cg.onlinepizzaapp.onlinepizzaapp.entity.PizzaOrder;
import com.cg.onlinepizzaapp.onlinepizzaapp.exception.OrderIdNotFoundException;
import com.cg.onlinepizzaapp.onlinepizzaapp.repository.IPizzaOrderRepository;




@Service
@Transactional
public class PizzaOrderServiceImpl implements IPizzaOrderService {

	@Autowired
	private IPizzaOrderRepository pizzaOrderRepository;
	
	@Override
	public PizzaOrder bookPizzaOrder(PizzaOrder order) {
		PizzaOrder order1=order;
		order1.setTotalCost( getCostAfterCoupon(order));
		pizzaOrderRepository.save(order1);
		return order1;
	}

	
	@Override
	public PizzaOrder updatePizzaOrder(PizzaOrder order) throws OrderIdNotFoundException {
		//return dao.save(order);
		Optional<PizzaOrder> o = pizzaOrderRepository.findById(order.getBookingOrderId());
		if (o.isPresent()) {
			order.setTotalCost(getCostAfterCoupon(order));
			return pizzaOrderRepository.save(order);
		} else {
			throw new OrderIdNotFoundException("Order id is not found");
		}
	}
	
	
	@Override
	public PizzaOrder cancelPizzaOrder(Integer bookingOrderId) throws OrderIdNotFoundException{
		Optional<PizzaOrder> pizzaOrd=pizzaOrderRepository.findById(bookingOrderId);
		if(pizzaOrd.isEmpty()) {
		    throw new OrderIdNotFoundException("Enter a valid Order ID");
		}
		pizzaOrderRepository.deleteById(bookingOrderId);
		return null;
	}

	@Override
	public PizzaOrder viewPizzaOrder(Integer bookingOrderId) throws OrderIdNotFoundException {
		Optional<PizzaOrder> o = pizzaOrderRepository.findById(bookingOrderId);
		if (o.isPresent()) {
			return o.get();

		} else {
			throw new OrderIdNotFoundException("Order id is not found");
		}
	}

	
	@Override
	public List<PizzaOrder> viewOrdersList() {
		return pizzaOrderRepository.findAll();
		
	}

	@Override
	public List<PizzaOrder> viewOrdersList(LocalDate date) {
		List<PizzaOrder> pizz=pizzaOrderRepository.findByorderDate(date);
		return pizz;
	}
	
		
	public Double calculateTotal(PizzaOrder order) {
		List<Pizza> plist = order.getPizza();
		double sum = 0.0;
		for (Pizza p : plist) {
			sum += p.getPizzaCost();
		}
		double total=sum*order.getQuantity();
		
		return total;
	}
	
	@Override
	public Double getCostAfterCoupon(PizzaOrder order) {

		double total=calculateTotal(order);
		double costAfterCoupon = total - order.getCoupan().getCoupanCost();
		return costAfterCoupon;
		
	}
   
}



