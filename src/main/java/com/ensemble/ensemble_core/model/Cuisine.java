package com.ensemble.ensemble_core.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name="Cuisines")
@Table(name="Cuisines")
@Data
public class Cuisine {
    @SequenceGenerator(name="cuisine_sequence",sequenceName ="cuisine_sequence",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cuisine_sequence")
    @Id
    private int cuisineId;
    private String cuisineName;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "cuisinesAvailable")
    @JsonIgnore
    private List<Restaurant> availableAt;
}
