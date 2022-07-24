package com.cg.onlinepizzaapp.onlinepizzaapp.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
public class PizzaOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private int bookingOrderId;
@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
@NotBlank(message = "It should not be Blank")
private LocalDate orderDate;
private String transactionMode;
@NotBlank(message = "It should not be Blank")
private int quantity;
private String size;

private double totalCost;

@Autowired
//@OneToMany(targetEntity=PizzaOrder.class,cascade=CascadeType.ALL)
//@JoinColumn(name="pizzaorder_pizza",referencedColumnName="bookingOrderId")
@OneToMany(cascade= {CascadeType.ALL})
@Fetch(FetchMode.JOIN)
@JoinColumn(name="bookingOrderId",referencedColumnName="bookingOrderId")
private List<Pizza> pizza;
@Autowired
@OneToOne
private Order order;
@Autowired
@OneToOne(cascade= CascadeType.ALL)
private Coupan coupan;

public PizzaOrder(LocalDate orderDate, String transactionMode, int quantity, String size, double totalCost,
		List<Pizza> pizza, Order order, Coupan coupan) {
	super();
	this.orderDate = orderDate;
	this.transactionMode = transactionMode;
	this.quantity = quantity;
	this.size = size;
	this.totalCost = totalCost;
	this.pizza = pizza;
	this.order = order;
	this.coupan = coupan;
}
public int getBookingOrderId() {
	return bookingOrderId;
}
public void setBookingOrderId(int bookingOrderId) {
	this.bookingOrderId = bookingOrderId;
}
public LocalDate getOrderDate() {
	return orderDate;
}
public void setOrderDate(LocalDate orderDate) {
	this.orderDate = orderDate;
}
public String getTransactionMode() {
	return transactionMode;
}
public void setTransactionMode(String transactionMode) {
	this.transactionMode = transactionMode;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public String getSize() {
	return size;
}
public void setSize(String size) {
	this.size = size;
}
public double getTotalCost() {
	return totalCost;
}

public void setTotalCost(double totalCost) {
	this.totalCost = totalCost;
}


public List<Pizza> getPizza() {
	return pizza;
}
public void setPizza(List<Pizza> pizza) {
	this.pizza = pizza;
}
public Order getOrder() {
	return order;
}
public void setOrder(Order order) {
	this.order = order;
}
public Coupan getCoupan() {
	return coupan;
}
public void setCoupan(Coupan coupan) {
	this.coupan = coupan;
}

}
