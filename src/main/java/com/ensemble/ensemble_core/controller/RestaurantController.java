package com.ensemble.ensemble_core.controller;


import com.ensemble.ensemble_core.model.Coupon;
import com.ensemble.ensemble_core.model.Restaurant;
import com.ensemble.ensemble_core.repository.CouponRepository;
import com.ensemble.ensemble_core.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/restaurant")
@CrossOrigin
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping
    public List<Restaurant> getAllRestaurants(){
        return restaurantService.getAllRestaurants();
    }

    @PostMapping
    public String addRestaurant(@RequestBody Restaurant restaurant){
        return restaurantService.addRestaurant(restaurant);
    }
}
