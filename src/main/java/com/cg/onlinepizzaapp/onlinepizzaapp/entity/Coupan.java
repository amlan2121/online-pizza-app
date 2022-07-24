package com.cg.onlinepizzaapp.onlinepizzaapp.entity;


import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;


@Entity
public class Coupan {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int coupanId;
	@NotBlank(message = "It should not be Blank")
	private String coupanName;
	
	private String coupanType;
	private String coupanDescription;
	@NotBlank(message = "It should not be Blank")
	private int coupanCost;

	public Coupan(String coupanName, String coupanType, String coupanDescription, int coupanCost) {
		super();
		this.coupanName = coupanName;
		this.coupanType = coupanType;
		this.coupanDescription = coupanDescription;
		this.coupanCost = coupanCost;
	}

	public int getCoupanId() {
		return coupanId;
	}

	public void setCoupanId(int coupanId) {
		this.coupanId = coupanId;
	}

	public String getCoupanName() {
		return coupanName;
	}

	public void setCoupanName(String coupanName) {
		this.coupanName = coupanName;
	}

	public String getCoupanType() {
		return coupanType;
	}

	public void setCoupanType(String coupanType) {
		this.coupanType = coupanType;
	}

	public String getCoupanDescription() {
		return coupanDescription;
	}

	public void setCoupanDescription(String coupanDescription) {
		this.coupanDescription = coupanDescription;
	}

	public int getCoupanCost() {
		return coupanCost;
	}

	public void setCoupanCost(int coupanCost) {
		this.coupanCost = coupanCost;
	}

}

