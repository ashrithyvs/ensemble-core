package com.ensemble.ensemble_core.service;

import com.ensemble.ensemble_core.model.Restaurant;

import java.util.List;

public interface RestaurantService {
    public List<Restaurant> getAllRestaurants();
    public String addRestaurant(Restaurant restaurant);
}
