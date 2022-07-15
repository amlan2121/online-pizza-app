package com.cg.onlinepizzaapp.onlinepizzaapp.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlinepizzaapp.onlinepizzaapp.entity.Coupon;



@Repository
public interface ICouponRepository extends JpaRepository<Coupon, Integer> {

}