package com.ensemble.ensemble_core.service;

import com.ensemble.ensemble_core.model.Cuisine;
import com.ensemble.ensemble_core.model.Dish;
import com.ensemble.ensemble_core.model.Restaurant;
import com.ensemble.ensemble_core.repository.DishesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishServiceImpl implements DishService{

    @Autowired
    private DishesRepository dishesRepository;
    @Autowired
    private CuisineService cuisineService;

    @Override
    public List<Dish> getAllDishes() {
        return dishesRepository.findAll();
    }

    @Override
    public Dish addDish(Dish dish) {
        if(null!=dish.getCuisine()){
            Cuisine cuisine = cuisineService.getCuisineByCuisineName(dish.getCuisine().getCuisineName());
            if(null!=cuisine) dish.setCuisine(cuisine);
        }
        return dishesRepository.save(dish);
    }

    @Override
    public Dish getDishByDishName(String dishName){
        return dishesRepository.findOneByDishName(dishName);
    }

    @Override
    public List<Restaurant> getRestaurantsByDishName(String dishName){
        return dishesRepository.findRestaurantsByDishName(dishName);
    }
}
