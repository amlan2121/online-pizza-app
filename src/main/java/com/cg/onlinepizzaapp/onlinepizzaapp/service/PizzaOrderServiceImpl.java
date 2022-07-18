package com.cg.onlinepizzaapp.onlinepizzaapp.service;

import java.time.LocalDate;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.cg.onlinepizzaapp.onlinepizzaapp.entity.PizzaOrder;
import com.cg.onlinepizzaapp.onlinepizzaapp.exception.OrderIdNotFoundException;
import com.cg.onlinepizzaapp.onlinepizzaapp.repository.IPizzaOrderRepository;


//@Service
//public class PizzaOrderServiceImpl implements IPizzaOrderService {
//	
//	@Autowired
//	public IPizzaOrderRepository pizzaorderRepository;
//	
//	@Override
//	public PizzaOrder bookPizzaOrder(PizzaOrder order) {
//
//		pizzaorderRepository.save(order);
//		return order;
//
//	}
//
//	@Override
//	public PizzaOrder updatePizzaOrder(PizzaOrder order) throws OrderIdNotFoundException{
//		Optional<PizzaOrder> o = pizzaorderRepository.findById(order.getBookingOrderId());
//		if (o.isPresent()) {
//
//			return pizzaorderRepository.save(order);
//		} else {
//			throw new OrderIdNotFoundException("Order id is not found");
//		}
//	}
//
//
//	@Override
//	public PizzaOrder cancelPizzaOrder(Integer bookingOrderId) throws OrderIdNotFoundException {
//		Optional<PizzaOrder> o = pizzaorderRepository.findById(bookingOrderId);
//		if (o.isPresent()) {
//			pizzaorderRepository.deleteById(bookingOrderId);
//			return o.get();
//		} else {
//			throw new OrderIdNotFoundException("Order id is not found");
//		}
//	}
//
//	@Override
//	public PizzaOrder viewPizzaOrder(Integer bookingOrderId) throws OrderIdNotFoundException {
//		Optional<PizzaOrder> o = pizzaorderRepository.findById(bookingOrderId);
//		if (o.isPresent()) {
//			return o.get();
//
//		} else {
//			throw new OrderIdNotFoundException("Order id is not found");
//		}
//	}
//
//	@Override
//	public List<PizzaOrder> viewOrdersList() throws OrderIdNotFoundException {
//		List<PizzaOrder> list = new ArrayList<>();
//		pizzaorderRepository.findAll().forEach(list::add);
//		if(list.isEmpty())
//		{
//			throw new OrderIdNotFoundException("The Order List Is Empty");
//		}
//		else
//		{
//			return list;
//		}
//	}
//
//	@Override
//	public List<PizzaOrder> viewOrdersList(LocalDate date) {
//		List<PizzaOrder> pizz=pizzaorderRepository.findByorderDate(date);
//		return pizz;
//	}
//
//	@Override
//	public PizzaOrder calculateTotal(PizzaOrder order) {
//		double sum=0;
//		for(Pizza p:order.getPizza()) {
//			sum+=p.getPizzaCost()*order.getQuantity();
//			
//		}
//		order.setTotalCost(sum);
//		return order;
//		
//	}
	
//	public PizzaOrder getCostAfterCoupon(PizzaOrder order) {
//
//		PizzaOrder order1 = calculateTotal(order);
//		double fetchTotalCost = order1.getTotalCost();
//		double costAfterCoupon = fetchTotalCost - ((order1.getCoupan().getCoupanPizzaId() * fetchTotalCost) / 100);
//		order1.setTotalCost(fetchTotalCost);
//		return order1;
//	}
	


	

//}

@Service("name=pizzaorderservice")
@Transactional
public class PizzaOrderServiceImpl implements IPizzaOrderService {

	@Autowired
	private IPizzaOrderRepository dao;
	
	@Override
	public PizzaOrder bookPizzaOrder(PizzaOrder order) {
		return dao.save(order);
	}

	
	@Override
	public PizzaOrder updatePizzaOrder(PizzaOrder order) {
		return dao.save(order);
	}
	
	
	@Override
	public PizzaOrder cancelPizzaOrder(Integer bookingOrderId) throws OrderIdNotFoundException{
		Optional<PizzaOrder> pizzaOrd=dao.findById(bookingOrderId);
		if(pizzaOrd.isEmpty()) {
		    throw new OrderIdNotFoundException("Enter a valid Order ID");
		}
		dao.deleteById(bookingOrderId);
		return null;
	}

	@Override
	public PizzaOrder viewPizzaOrder(Integer bookingOrderId) throws OrderIdNotFoundException {
		Optional<PizzaOrder> o = dao.findById(bookingOrderId);
		if (o.isPresent()) {
			return o.get();

		} else {
			throw new OrderIdNotFoundException("Order id is not found");
		}
	}

	
	@Override
	public List<PizzaOrder> viewOrdersList() {
		return dao.findAll();
		
	}

	@Override
	public List<PizzaOrder> viewOrdersList(LocalDate date) {
		List<PizzaOrder> pizz=dao.findByorderDate(date);
		return pizz;
	}
	
	@Override
	public String calculateTotal(String size, double quantity) {
		return IPizzaOrderRepository.calculateTotal(size, quantity);
	}
   
}



