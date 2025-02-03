package com.ensemble.ensemble_core.controller;


import com.ensemble.ensemble_core.model.Dish;
import com.ensemble.ensemble_core.model.Restaurant;
import com.ensemble.ensemble_core.repository.RestaurantRepository;
import com.ensemble.ensemble_core.service.DishService;
import com.ensemble.ensemble_core.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin
public class DishController {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private DishService dishService;

    @PostMapping("/restaurant/{restaurantId}/dishes")
    public ResponseEntity<Dish> addDish(@PathVariable(value = "restaurantId") int restaurantId, @RequestBody Dish dishRequest) {
        Dish dish = restaurantRepository.findById(restaurantId).map(restaurant -> {
            //get dish if exists in DB
            Dish _dish = dishService.getDishByDishName(dishRequest.getDishName());

            //if dish exists in DB and also in restaurant, just return the dish.
            List<Dish> dishExists =restaurant.getDishesLiked().stream().filter(o -> o.getDishName().equals(dishRequest.getDishName())).toList();
            if (!dishExists.isEmpty()) return _dish;

            //if dish exists in DB but not in restaurant, add in and save the restaurant.
            if (null!=_dish) {
                restaurant.addDishToDishesLiked(_dish);
                restaurantService.addRestaurant(restaurant);
                return _dish;
            }

            // if the dish doesn't exists in DB, add and create a new Dish
            restaurant.addDishToDishesLiked(dishRequest);
            return dishService.addDish(dishRequest);
        }).orElseThrow(() -> new IllegalArgumentException("No Restaurant is found with id = " + restaurantId));

        return new ResponseEntity<>(dish, HttpStatus.CREATED);
    }

    @PostMapping("/dish")
    public ResponseEntity<Dish> addDish(@RequestBody Dish dishRequest){
        return new ResponseEntity<>(dishService.addDish(dishRequest), HttpStatus.CREATED);
    }

    @GetMapping("/dish")
    public ResponseEntity<List<Restaurant>> getRestaurantsByDishName(@RequestBody Dish dish){
        List<Restaurant> restaurantsFound = dishService.getRestaurantsByDishName(dish.getDishName());
        if(restaurantsFound.isEmpty()) throw new IllegalArgumentException("No Restaurants found associated to this Dish");
        return new ResponseEntity<>(restaurantsFound, HttpStatus.FOUND);
    }
}
