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
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
@Entity
public class PizzaOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private int bookingOrderId;
private LocalDate orderDate;
private String transactionMode;
private int quantity;
private String size;
private double totalCost;

@Autowired
@OneToMany(targetEntity=Pizza.class,cascade=CascadeType.ALL)
@JoinColumn(name="pizzaorder_pizza",referencedColumnName="bookingOrderId")
private List<Pizza> pizza;
@Autowired
@OneToOne
private Order order;
@Autowired
@OneToOne
private Coupan coupan;

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
