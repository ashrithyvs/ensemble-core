package com.ensemble.ensemble_core.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.net.URL;
import java.util.List;

@Getter
@Setter
@Entity(name = "Dishes")
@Table(name="Dishes")
@Data
public class Dish {
    @SequenceGenerator(name="dish_sequence",sequenceName ="dish_sequence",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dish_sequence")
    @Id
    private int dishId;
    private String dishName;
    private String description;
    private URL dishImage;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(
            name = "cuisineId",
            referencedColumnName = "cuisineId"
    )
    private Cuisine cuisine;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "menuItems")
    @JsonIgnore
    private List<Restaurant> availableAt;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "dishesLiked")
    @JsonIgnore
    private List<Restaurant> popularAt;
}
