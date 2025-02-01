package com.ensemble.ensemble_core.service;

import com.ensemble.ensemble_core.model.Coupon;

import java.util.ArrayList;
import java.util.List;

public interface CouponService {
     List<Coupon> getAllCoupons();
     String addCoupon(Coupon coupon);
     ArrayList<Coupon> getCoupons(int restaurantId);
     void updateCoupon(int couponId, int restaurantId);
}
