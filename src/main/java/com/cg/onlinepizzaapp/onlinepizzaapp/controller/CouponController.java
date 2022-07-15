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

import com.cg.onlinepizzaapp.onlinepizzaapp.entity.Coupon;
import com.cg.onlinepizzaapp.onlinepizzaapp.exception.CouponIdNotFoundException;
import com.cg.onlinepizzaapp.onlinepizzaapp.exception.InvalidCouponOperationException;
import com.cg.onlinepizzaapp.onlinepizzaapp.service.ICouponService;



@CrossOrigin(origins = "*")
@RestController
public class CouponController {
	@Autowired
	private ICouponService service;

	@PostMapping("/savecoupon")
	Coupon addCoupon(@RequestBody Coupon coupon) {
		return service.addCoupons(coupon);
	}
	

	@GetMapping("/showcoupon/{couponId}")
	List<Coupon> viewCoupon(@PathVariable String couponId)  throws CouponIdNotFoundException{
		return service.viewCoupon(Integer.parseInt(couponId));
	}

	@GetMapping("/showcouponlist")
	List<Coupon> viewCoupons() throws  CouponIdNotFoundException {
		return service.viewCoupons();
	}

	@PutMapping("/updatecoupon")
	Coupon updateCoupon(@RequestBody Coupon coupon) throws InvalidCouponOperationException{
		return service.editCoupons(coupon);
	}

	@DeleteMapping("/deletecoupon/{couponId}")
	String deleteCoupon(@PathVariable String couponId) throws CouponIdNotFoundException {
		service.deleteCoupons(Integer.parseInt(couponId));
		return "Coupon with coupon id " + couponId + " got deleted";
	}
}