package com.cg.onlinepizzaapp.onlinepizzaapp.service;

import java.util.List;

import com.cg.onlinepizzaapp.onlinepizzaapp.entity.Coupon;
import com.cg.onlinepizzaapp.onlinepizzaapp.exception.CouponIdNotFoundException;
import com.cg.onlinepizzaapp.onlinepizzaapp.exception.InvalidCouponOperationException;

public interface ICouponService {

	Coupon addCoupons(Coupon coupon);

	Coupon editCoupons(Coupon coupon) throws InvalidCouponOperationException;

	void deleteCoupons(int couponId)throws CouponIdNotFoundException;

	List<Coupon> viewCoupons() throws CouponIdNotFoundException;

	List<Coupon> viewCoupon(int couponId)throws CouponIdNotFoundException;
	
	Coupon viewCouponByName(String couponName) throws CouponIdNotFoundException;

	

	
	
	
}