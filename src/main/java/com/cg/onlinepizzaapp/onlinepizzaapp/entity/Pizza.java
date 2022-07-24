
package com.cg.onlinepizzaapp.onlinepizzaapp.entity;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
public class Pizza {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pizzaId;
	@NotBlank(message = "It should not be Blank")
	private String pizzaName;
	@NotBlank(message = "It should not be Blank")
	private String pizzaType;
	private String pizzaDescription;
	@NotBlank(message = "It should not be Blank")
	private double pizzaCost;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="bookingOrderId")
	@JsonBackReference
	private PizzaOrder pizzaOrder;
	public Pizza() {
		
	}
	public Pizza( String pizzaName, String pizzaType, String pizzaDescription, double pizzaCost
		) {
		super();
	//	this.pizzaId = pizzaId;
		this.pizzaName = pizzaName;
		this.pizzaType = pizzaType;
		this.pizzaDescription = pizzaDescription;
		this.pizzaCost = pizzaCost;

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
//	public double getPizzaCostAfterCoupon() {
//		return pizzaCostAfterCoupon;
//	}
//	public void setPizzaCostAfterCoupon(double pizzaCostAfterCoupon) {
//		this.pizzaCostAfterCoupon = pizzaCostAfterCoupon;
//	}

}
