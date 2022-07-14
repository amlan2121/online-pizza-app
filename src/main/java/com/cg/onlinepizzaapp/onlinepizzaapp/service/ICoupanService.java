package com.cg.onlinepizzaapp.onlinepizzaapp.service;

import java.util.List;

import com.cg.onlinepizzaapp.onlinepizzaapp.entity.Coupan;
public interface ICoupanService {

	public Coupan addCoupans(Coupan coupan);
	public Coupan editCoupans(Coupan coupan);
	public Coupan deleteCoupans(Integer coupanId);
	public List<Coupan> viewCoupans();
	
}
