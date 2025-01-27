package com.ensemble.ensemble_core.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table
public class Restaurant {

    @SequenceGenerator(name="restaurant_sequence",sequenceName ="restaurant_sequence",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "restaurant_sequence")
    @Id
    private int rid;
    private String restaurantName;
    private String address;
    private String location;
    private String url;
    private boolean online_order ;
    private boolean book_table ;
    private float rate ;
    private long votes ;
    private String phone ;
    private String rest_type ;
    private List<String> dish_liked ;
    private List<String> cuisines ;
    private int approx_cost ;
    private List<String> reviewList ;
    private String menu_item ;
    private String listed_in_type ;
    private String listed_in_city ;
}
