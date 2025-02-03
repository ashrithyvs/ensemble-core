package com.ensemble.ensemble_core.service;

import com.ensemble.ensemble_core.model.Cuisine;
import com.ensemble.ensemble_core.model.Dish;
import com.ensemble.ensemble_core.model.Restaurant;
import com.ensemble.ensemble_core.model.Review;
import com.ensemble.ensemble_core.repository.CuisineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuisineServiceImpl implements CuisineService{

    @Autowired
    private CuisineRepository cuisineRepository;

    @Override
    public Cuisine getCuisineByCuisineName(String cuisineName) {
        return cuisineRepository.findOneByCuisineName(cuisineName);
    }

    @Override
    public String addCuisine(Cuisine cuisine) {
        try {
            cuisineRepository.save(cuisine);
            return "Cuisine Added Successfully";
        }catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public List<Restaurant> getRestaurantsByCuisineName(String cuisineName) {
        return cuisineRepository.findRestaurantsByCuisineName(cuisineName);
    }

    @Override
    public List<Dish> getDishesByCuisineName(String cuisineName){
        return cuisineRepository.findDishesByCuisineName(cuisineName);
    }
}
