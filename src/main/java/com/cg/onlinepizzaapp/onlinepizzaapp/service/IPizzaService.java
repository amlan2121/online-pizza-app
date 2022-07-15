package com.cg.onlinepizzaapp.onlinepizzaapp.service;

import java.util.List;

import com.cg.onlinepizzaapp.onlinepizzaapp.entity.Pizza;
import com.cg.onlinepizzaapp.onlinepizzaapp.exception.InvalidMinCostException;
import com.cg.onlinepizzaapp.onlinepizzaapp.exception.PizzaIdNotFoundException;


public interface IPizzaService {

	public Pizza addPizza(Pizza pizza);
	public Pizza updatePizza(Pizza pizza);
	public Pizza viewPizza(int pizzaId) throws PizzaIdNotFoundException;
	public List<Pizza> viewPizzaList();
	public List<Pizza> viewPizzaList(Double minCost,Double maxCost) throws InvalidMinCostException;
	public List<Pizza> viewPizzaList(String pizzaType);
	public Pizza deletePizza(int pizzaId) throws PizzaIdNotFoundException; 
	
}
