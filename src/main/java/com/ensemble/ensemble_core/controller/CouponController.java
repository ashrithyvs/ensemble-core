package com.ensemble.ensemble_core.controller;


import com.ensemble.ensemble_core.model.Coupon;
import com.ensemble.ensemble_core.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/coupon")
@CrossOrigin
public class CouponController {

    @Autowired
    private CouponService couponService;

    @GetMapping
    public List<Coupon> getAllCoupons(){
        return couponService.getAllCoupons();
    }

    @PostMapping
    public String addCoupon(@RequestBody Coupon coupon){
        return couponService.addCoupon(coupon);
    }

    @GetMapping("/getCoupon/{restaurantId}")
    public ArrayList<Coupon> getCoupon(@PathVariable int restaurantId){
        return couponService.getCoupons(restaurantId);
    }
}
