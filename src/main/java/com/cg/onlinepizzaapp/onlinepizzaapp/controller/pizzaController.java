package com.cg.onlinepizzaapp.onlinepizzaapp.controller;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.cg.onlinepizzaapp.onlinepizzaapp.entity.Pizza;
import com.cg.onlinepizzaapp.onlinepizzaapp.exception.InvalidMinCostException;
import com.cg.onlinepizzaapp.onlinepizzaapp.exception.PizzaIdNotFoundException;
import com.cg.onlinepizzaapp.onlinepizzaapp.service.IPizzaService;


@CrossOrigin(origins = "*")
@RestController
public class pizzaController {
	
	@Autowired
	private IPizzaService pizzaService;
	

	@PostMapping("/addpizza")
	public Pizza addPizza( @RequestBody Pizza pizza) {
		return pizzaService.addPizza(pizza);
	}
	
	@PutMapping("/updatepizza")
	public Pizza updatePizza(@RequestBody Pizza pizza) {
		return pizzaService.updatePizza(pizza);
	}
	
	@DeleteMapping("/deletepizza/{id}")
	public String deletePizza(@PathVariable("id") int id) throws PizzaIdNotFoundException {
		pizzaService.deletePizza(id);
		return "Pizza - " + id + " deleted successfully";
	}
	
	@GetMapping("/viewpizza")
	public List<Pizza> viewPizzaList() {
		return pizzaService.viewPizzaList();
	}
	
	@GetMapping("/viewpizza/{id}")
	public Pizza viewPizza(@PathVariable("id") int id) throws PizzaIdNotFoundException {
		return pizzaService.viewPizza(id);
	}
	
	@GetMapping("/viewpizza/{minCost}/{maxCost}")
	public List<Pizza> viewPizzaList(@PathVariable("minCost") double minCost, @PathVariable("maxCost") double maxCost)
			throws InvalidMinCostException {
		return pizzaService.viewPizzaList(minCost, maxCost);
	}
	
	@GetMapping("/viewpizza/type/{type}")
	public List<Pizza> viewPizzaList(@PathVariable("type") String pizzaType) {
		return pizzaService.viewPizzaList(pizzaType);
	}
	

	
	

	

}
