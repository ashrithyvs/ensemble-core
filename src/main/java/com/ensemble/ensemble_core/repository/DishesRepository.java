package com.ensemble.ensemble_core.repository;

import com.ensemble.ensemble_core.model.Dish;
import com.ensemble.ensemble_core.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DishesRepository extends JpaRepository<Dish, Integer> {
    @Query("FROM Dishes d WHERE d.dishName=?1")
    Dish findOneByDishName(String dishName);

    @Query("SELECT r FROM Restaurants r JOIN r.dishesLiked d WHERE d.dishName = :dishName")
    List<Restaurant> findRestaurantsByDishName(String dishName);
}
