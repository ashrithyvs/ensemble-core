package com.ensemble.ensemble_core.service;

import com.ensemble.ensemble_core.model.Coupon;
import com.ensemble.ensemble_core.model.Dish;
import com.ensemble.ensemble_core.model.Restaurant;

import java.util.ArrayList;
import java.util.List;

public interface DishService {
     List<Dish> getAllDishes();
     Dish addDish(Dish dish);
     Dish getDishByDishName(String dishName);
     List<Restaurant> getRestaurantsByDishName(String dishName);
}
