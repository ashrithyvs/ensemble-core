package com.ensemble.ensemble_core.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity(name="Restaurants")
@Table(name="Restaurants")
@Data
public class Restaurant {

    @SequenceGenerator(name="restaurant_sequence",sequenceName ="restaurant_sequence",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "restaurant_sequence")
    @Id
    private int restaurantId;
    private String restaurantName;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "locationId", referencedColumnName = "locationId")
    private Location location;
    private String url;
    private boolean online_order ;
    private boolean book_table ;
    private float rate ;
    private long votes ;
    private String phone ;
    private String rest_type ;
    private int approx_cost ;
    private String menu_item ;
    private String listed_in;
    private String peakTimes ;

    private List<Integer> couponsAvailable;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name = "dishesLiked",
            joinColumns = @JoinColumn(name = "restaurantId"),
            inverseJoinColumns = @JoinColumn(name = "dishId"))
    private List<Dish> dishesLiked ;

    @ManyToMany
    @JoinTable(
            name = "cuisinesAvailable",
            joinColumns = @JoinColumn(name = "restaurantId"),
            inverseJoinColumns = @JoinColumn(name = "cuisineId"))
    private List<Cuisine> cuisinesAvailable ;

    public void addDish(Dish dish) {
        this.dishesLiked.add(dish);
        if(null==dish.getRestaurants()){
            dish.setRestaurants(new ArrayList<Restaurant>());
        }
        dish.getRestaurants().add(this);
    }
}
