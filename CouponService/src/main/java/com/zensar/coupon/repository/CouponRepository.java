package com.zensar.coupon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zensar.coupon.entity.Coupon;


@Repository
public interface CouponRepository extends JpaRepository<Coupon, Integer>{

	Coupon findByCouponCode(String couponCode);
	
}
