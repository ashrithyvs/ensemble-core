package com.ensemble.ensemble_core.service;

import com.ensemble.ensemble_core.model.*;
import com.ensemble.ensemble_core.repository.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private static final Logger logger = LogManager.getLogger(RestaurantServiceImpl.class);

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private CouponService couponService;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private DishesRepository dishesRepository;

    @Autowired
    private CuisineRepository cuisineRepository;


    @Override
    public List<Restaurant> getAllRestaurants(){
        return restaurantRepository.findAll();
    }

    public Restaurant getRestaurantById(int restaurantId){ return restaurantRepository.findById(restaurantId).orElseThrow(()-> new IllegalArgumentException("Restaurant Not Found"));}

    @Override
    public List<Restaurant> getRestaurantsByLocationName(String location) {
        return restaurantRepository.findRestaurantsByLocationName(location);
    }

    @Override
    public String addRestaurant(Restaurant restaurant){
        if(null!=restaurant.getLocation()){
            Location loc = locationRepository.findOneByAddress(restaurant.getLocation().getAddress());
            if(null!=loc){
                restaurant.getLocation().setLocationId(loc.getLocationId());
            }else locationRepository.save(restaurant.getLocation());
        }
        if(!restaurant.getDishesLiked().isEmpty()){
            List<Dish> dflist= new ArrayList<>();
            restaurant.getDishesLiked().forEach(d ->{
                Dish df = dishesRepository.findOneByDishName(d.getDishName());
                if(null==df) dishesRepository.save(d);
                dflist.add(df);
            });
            restaurant.setDishesLiked(dflist);
        }

        if(!restaurant.getCuisinesAvailable().isEmpty()){
            List<Cuisine> cflist= new ArrayList<>();
            restaurant.getCuisinesAvailable().forEach(c ->{
                Cuisine cf = cuisineRepository.findOneByCuisineName(c.getCuisineName());
                if(null==cf) cuisineRepository.save(c);
                cflist.add(cf);
            });
            restaurant.setCuisinesAvailable(cflist);
        }

       Restaurant _restaurant = restaurantRepository.save(restaurant);

        if(!restaurant.getCouponsAvailable().isEmpty()){
            restaurant.getCouponsAvailable().forEach(c ->{
                couponService.updateCoupon(_restaurant.getRestaurantId(),c);
            });
        }
        return "Restaurant Added";
    }
}
