package com.cg.onlinepizzaapp.onlinepizzaapp.service;

import java.util.List;

import com.cg.onlinepizzaapp.onlinepizzaapp.entity.Pizza;


public interface IPizzaService {

	public Pizza addPizza(Pizza pizza);
	public Pizza updatePizza(Pizza pizza);
	public Pizza deletePizza(Integer pizzaId);
	public Pizza viewPizza(Integer pizzaId);
	public List<Pizza> viewPizzaList();
	public List<Pizza> viewPizzaList(Double minCost,Double maxCost);
	public List<Pizza> viewPizzaList(String pizzaType); 
	
}
