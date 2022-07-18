package com.cg.onlinepizzaapp.onlinepizzaapp.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity

public class Customer{
	@OneToOne(cascade = CascadeType.ALL)
	private User user;
	@Id
	private int customerId;
	
	private String customerName;
	private long customerMobile;
	private String customerEmail;
	private String customerAddress;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	public Customer(User user, int customerId, String customerName, long customerMobile, String customerEmail,
			String customerAddress) {
		super();
		this.user = user;
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerMobile = customerMobile;
		this.customerEmail = customerEmail;
		this.customerAddress = customerAddress;
	}





	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public long getCustomerMobile() {
		return customerMobile;
	}
	public void setCustomerMobile(long customerMobile) {
		this.customerMobile = customerMobile;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}