package com.ensemble.ensemble_core.service;

import com.ensemble.ensemble_core.model.Coupon;
import com.ensemble.ensemble_core.model.Dish;
import com.ensemble.ensemble_core.model.Location;
import com.ensemble.ensemble_core.model.Restaurant;
import com.ensemble.ensemble_core.repository.CouponRepository;
import com.ensemble.ensemble_core.repository.DishesRepository;
import com.ensemble.ensemble_core.repository.LocationRepository;
import com.ensemble.ensemble_core.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private CouponService couponService;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private DishesRepository dishesRepository;


    @Override
    public List<Restaurant> getAllRestaurants(){
        return restaurantRepository.findAll();
    }

    public Restaurant getRestaurantById(int restaurantId){ return restaurantRepository.findById(restaurantId).orElseThrow(()-> new IllegalArgumentException("Restaurant Not Found"));}

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
        Restaurant _restaurant = restaurantRepository.save(restaurant);

        if(!restaurant.getCouponsAvailable().isEmpty()){
            restaurant.getCouponsAvailable().forEach(c ->{
                couponService.updateCoupon(_restaurant.getRestaurantId(),c);
            });
        }
        return "Restaurant Added";
    }
}
