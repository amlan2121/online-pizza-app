package com.cg.onlinepizzaapp.onlinepizzaapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinepizzaapp.onlinepizzaapp.entity.Pizza;
import com.cg.onlinepizzaapp.onlinepizzaapp.exception.InvalidMinCostException;
import com.cg.onlinepizzaapp.onlinepizzaapp.exception.PizzaIdNotFoundException;
import com.cg.onlinepizzaapp.onlinepizzaapp.repository.IPizzaRepository;


@Service
public class PizzaServiceImpl implements IPizzaService {
	
	@Autowired
	IPizzaRepository pizzaRepository;

	@Override
	public Pizza addPizza(Pizza pizza) {
		// TODO Auto-generated method stub\
		Pizza result=pizzaRepository.save(pizza);
		return result;
		
	}
	@Override
	public Pizza updatePizza(Pizza pizza) {
		// TODO Auto-generated method stub
		Optional<Pizza> op = pizzaRepository.findById(pizza.getPizzaId());
		if(op.isPresent())
		{
			pizzaRepository.save(pizza);
		}
		return op.get();
	}
	
	@Override
	public Pizza deletePizza(int pizzaId) throws PizzaIdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Pizza> op = pizzaRepository.findById(pizzaId);
		if (op.isPresent()) {

			pizzaRepository.deleteById(pizzaId);
			System.out.println(op.get());
			return op.get();
		} 
		else 
		{
			throw new PizzaIdNotFoundException("Pizza id is not found");
		}
	}

	@Override
	public Pizza viewPizza(int pizzaId) throws PizzaIdNotFoundException {
		Optional<Pizza> op=this.pizzaRepository.findById(pizzaId);
		if(op.isPresent()) {
			return op.get();
		}
		else {
			throw new PizzaIdNotFoundException("Pizza id is not found");
		}
		
	}

	@Override
	public List<Pizza> viewPizzaList() {
		// TODO Auto-generated method stub
		List<Pizza> pizza=(List<Pizza>)pizzaRepository.findAll();
		return pizza;
	}

	@Override
	public List<Pizza> viewPizzaList(Double minCost, Double maxCost) throws InvalidMinCostException{
		// TODO Auto-generated method stub
		
		List<Pizza> pizza2=(List<Pizza>)pizzaRepository.findBypizzaCostBetween(minCost,maxCost);
		return pizza2;
	}

	@Override
	public List<Pizza> viewPizzaList(String pizzaType) {
//		List<Pizza> list = new ArrayList<>();
//		list.stream().filter(i->i.getPizzaType().equals(pizzaType)).collect(Collectors.toList());
		List<Pizza> pizza3=(List<Pizza>)pizzaRepository.findBypizzaTypeEquals(pizzaType);
		return pizza3;
	}
	
	

}
