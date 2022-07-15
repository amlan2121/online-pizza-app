package com.cg.onlinepizzaapp.onlinepizzaapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinepizzaapp.onlinepizzaapp.entity.Coupon;
import com.cg.onlinepizzaapp.onlinepizzaapp.exception.CouponIdNotFoundException;
import com.cg.onlinepizzaapp.onlinepizzaapp.exception.InvalidCouponOperationException;
import com.cg.onlinepizzaapp.onlinepizzaapp.repository.ICouponRepository;

@Service
public class CouponServiceImpl implements ICouponService {
	@Autowired
	public ICouponRepository repo;

	@Override
	public Coupon addCoupons(Coupon coupon) {
		Coupon rcoupon = repo.save(coupon);
		return rcoupon;
	}

	@Override
	public Coupon editCoupons(Coupon coupon) throws InvalidCouponOperationException {
		Optional<Coupon> rcoupon = repo.findById(coupon.getCouponId());
		if (rcoupon.isPresent()) {
			// repo.deleteById(coupon.getCouponId());
			repo.save(coupon);
			return rcoupon.get();
		} else {
			throw new InvalidCouponOperationException("Coupon is not available");
		}
	}

	@Override
	public void deleteCoupons(int couponId) throws CouponIdNotFoundException {
		Optional<Coupon> rcoupon = repo.findById(couponId);
		if (rcoupon.isPresent()) {
			repo.deleteById(couponId);

		} else {
			throw new CouponIdNotFoundException("There is no such Coupon");
		}

	}

	@Override
	public List<Coupon> viewCoupons() throws CouponIdNotFoundException {
		List<Coupon> list = new ArrayList<>();
		repo.findAll().forEach(list::add);
		if (list.isEmpty()) {
			throw new CouponIdNotFoundException("Empty");
		} else {
			return list;
		}
	}

	@Override
	public List<Coupon> viewCoupon(int couponId) throws CouponIdNotFoundException
	{
		List<Coupon> rlist = new ArrayList<Coupon>();
		Optional<Coupon> rcoupon = repo.findById(couponId);
		if (rcoupon.isPresent())
		{
			rlist.add(rcoupon.get());
			return rlist;
		} 
		else
		{
			throw new CouponIdNotFoundException("Coupon is not available");
		}	
	}

	@Override
	public Coupon viewCouponByName(String couponName) throws CouponIdNotFoundException {
		// TODO Auto-generated method stub
		List<Coupon> list= new ArrayList<Coupon>();
		list= repo.findAll();
		int d = 0;
		for(Coupon c : list) {
			c.getCouponDescription().equalsIgnoreCase(couponName);
			d=c.getCouponId();
			break;
		}
		Optional<Coupon> rcoupon = repo.findById(d);
		if (rcoupon.isPresent()) {
			return rcoupon.get();
		} else {
			throw new CouponIdNotFoundException("Coupon is not available");
		}
		
	}


}