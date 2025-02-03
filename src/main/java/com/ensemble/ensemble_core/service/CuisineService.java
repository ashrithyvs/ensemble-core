package com.ensemble.ensemble_core.service;

import com.ensemble.ensemble_core.model.Cuisine;
import com.ensemble.ensemble_core.model.Dish;
import com.ensemble.ensemble_core.model.Restaurant;

import java.util.List;

public interface CuisineService {
     Cuisine getCuisineByCuisineName(String cuisineName);
     String addCuisine(Cuisine cuisine);
     List<Restaurant> getRestaurantsByCuisineName(String cuisineName);
     List<Dish> getDishesByCuisineName(String cuisineName);
}
