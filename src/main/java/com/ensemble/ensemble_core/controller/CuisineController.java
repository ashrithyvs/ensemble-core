package com.ensemble.ensemble_core.controller;

import com.ensemble.ensemble_core.model.Cuisine;
import com.ensemble.ensemble_core.model.Dish;
import com.ensemble.ensemble_core.model.Restaurant;
import com.ensemble.ensemble_core.service.CuisineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cuisine")
@CrossOrigin
public class CuisineController {

    @Autowired
    private CuisineService cuisineService;

    @PostMapping
    public String addCuisine(@RequestBody Cuisine cuisine){
        return cuisineService.addCuisine(cuisine);
    }

    @GetMapping("/restaurants")
    public List<Restaurant> getRestaurantsByCuisineName(@RequestBody Cuisine cuisine){
        return cuisineService.getRestaurantsByCuisineName(cuisine.getCuisineName());
    }

    @GetMapping("/dishes")
    public List<Dish> getDishesByCuisineName(@RequestBody Cuisine cuisine){
        return cuisineService.getDishesByCuisineName(cuisine.getCuisineName());
    }


}
