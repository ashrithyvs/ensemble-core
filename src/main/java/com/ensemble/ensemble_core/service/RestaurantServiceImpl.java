package com.ensemble.ensemble_core.service;

import com.ensemble.ensemble_core.model.Restaurant;
import com.ensemble.ensemble_core.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public List<Restaurant> getAllRestaurants(){
        return restaurantRepository.findAll();
    }

    @Override
    public String addRestaurant(Restaurant restaurant){
        restaurantRepository.save(restaurant);
        return "Restaurant Added";
    }
}
