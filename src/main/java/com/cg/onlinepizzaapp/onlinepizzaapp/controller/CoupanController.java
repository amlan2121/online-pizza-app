package com.cg.onlinepizzaapp.onlinepizzaapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinepizzaapp.onlinepizzaapp.entity.Coupan;
import com.cg.onlinepizzaapp.onlinepizzaapp.exception.CoupanIdNotFoundException;
import com.cg.onlinepizzaapp.onlinepizzaapp.exception.InvalidCoupanOperationException;
import com.cg.onlinepizzaapp.onlinepizzaapp.service.ICoupanService;



@CrossOrigin(origins = "*")
@RestController
public class CoupanController {
	@Autowired
	private ICoupanService service;

	@PostMapping("/savecoupon")
	Coupan addCoupon(@RequestBody Coupan coupan) {
		return service.addCoupans(coupan);
	}
	

	@GetMapping("/showcoupon/{coupanId}")
	List<Coupan> viewCoupan(@PathVariable int coupanId)  throws CoupanIdNotFoundException{
		return service.viewCoupan(coupanId);
	}

	@GetMapping("/showcouponlist")
	List<Coupan> viewCoupans() throws  CoupanIdNotFoundException {
		return service.viewCoupans();
	}

	@PutMapping("/updatecoupon")
	Coupan updateCoupan(@RequestBody Coupan coupan) throws InvalidCoupanOperationException{
		return service.editCoupans(coupan);
	}

	@DeleteMapping("/deletecoupon/{coupanId}")
	String deleteCoupan(@PathVariable int coupanId) throws CoupanIdNotFoundException {
		service.deleteCoupans(coupanId);
		return "Coupon with coupon id " + coupanId + " got deleted";
	}
}