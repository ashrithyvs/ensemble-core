package com.ensemble.ensemble_core.service;

import com.ensemble.ensemble_core.model.Coupon;
import com.ensemble.ensemble_core.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class CouponServiceImpl implements CouponService {

    @Autowired
    private CouponRepository couponRepository;

    public List<Coupon> getAllCoupons() {
        return couponRepository.findAll();
    }

    public String addCoupon(@RequestBody Coupon coupon){
        try {
            couponRepository.save(coupon);
            return "Coupon added successfully";
        }catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    public ArrayList<Coupon> getCoupons(int restaurantId){
        return couponRepository.findCouponCodeByCanBeUsedAt(restaurantId);
    }

    public void updateCoupon(int restaurantId,int couponId){
        try {
            couponRepository.updateCoupon(restaurantId, couponId);
        }catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
}
