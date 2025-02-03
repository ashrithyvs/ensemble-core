package com.ensemble.ensemble_core.repository;

import com.ensemble.ensemble_core.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
    @Query("SELECT r FROM Restaurants r WHERE r.location.locationName = :location")
    List<Restaurant> findRestaurantsByLocationName(String location);
}
