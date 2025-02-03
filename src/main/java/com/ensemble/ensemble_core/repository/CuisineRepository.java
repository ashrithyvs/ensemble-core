package com.ensemble.ensemble_core.repository;

import com.ensemble.ensemble_core.model.Cuisine;
import com.ensemble.ensemble_core.model.Dish;
import com.ensemble.ensemble_core.model.Restaurant;
import com.ensemble.ensemble_core.model.Review;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CuisineRepository extends JpaRepository<Cuisine, Integer> {
    @Query("SELECT r FROM Restaurants r JOIN r.cuisinesAvailable d WHERE d.cuisineName = :cuisineName")
    List<Restaurant> findRestaurantsByCuisineName(String cuisineName);

    @Query("From Dishes d Where d.cuisine.cuisineName=:cuisineName")
    List<Dish> findDishesByCuisineName(String cuisineName);

    @Query("FROM Cuisines c WHERE c.cuisineName=:cuisineName")
    Cuisine findOneByCuisineName(String cuisineName);
}
