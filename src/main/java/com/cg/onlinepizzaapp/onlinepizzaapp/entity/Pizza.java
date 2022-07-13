package com.cg.onlinepizzaapp.onlinepizzaapp.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
public class Pizza {
	@Id
	private int pizzaId;
	private String pizzaName;
	private String pizzaType;
	private String pizzaDescription;
	private double pizzaCost;
	private double pizzaCostAfterCoupon;

	public Pizza(int pizzaId, String pizzaName, String pizzaType, String pizzaDescription, double pizzaCost,
		double pizzaCostAfterCoupon) {
		super();
		this.pizzaId = pizzaId;
		this.pizzaName = pizzaName;
		this.pizzaType = pizzaType;
		this.pizzaDescription = pizzaDescription;
		this.pizzaCost = pizzaCost;
		this.pizzaCostAfterCoupon = pizzaCostAfterCoupon;
	}
	public int getPizzaId() {
		return pizzaId;
	}
	public void setPizzaId(int pizzaId) {
		this.pizzaId = pizzaId;
	}
	public String getPizzaName() {
		return pizzaName;
	}
	public void setPizzaName(String pizzaName) {
		this.pizzaName = pizzaName;
	}
	public String getPizzaType() {
		return pizzaType;
	}
	public void setPizzaType(String pizzaType) {
		this.pizzaType = pizzaType;
	}
	public String getPizzaDescription() {
		return pizzaDescription;
	}
	public void setPizzaDescription(String pizzaDescription) {
		this.pizzaDescription = pizzaDescription;
	}
	public double getPizzaCost() {
		return pizzaCost;
	}
	public void setPizzaCost(double pizzaCost) {
		this.pizzaCost = pizzaCost;
	}
	public double getPizzaCostAfterCoupon() {
		return pizzaCostAfterCoupon;
	}
	public void setPizzaCostAfterCoupon(double pizzaCostAfterCoupon) {
		this.pizzaCostAfterCoupon = pizzaCostAfterCoupon;
	}

}
