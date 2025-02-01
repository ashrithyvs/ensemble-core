package com.ensemble.ensemble_core.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity(name="Reviews")
@Table(name="Reviews")
@Data
public class Review {
    @SequenceGenerator(name="review_sequence",sequenceName ="review_sequence",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "review_sequence")
    @Id
    private int reviewId;
    private float rating;
    private String review;

@ManyToOne
@JoinColumn( // this will add a user_id column to the message table as a foreign key
        name = "restaurantId", // specifies the name of the foreign key column in the database
        referencedColumnName = "restaurantId" // primary key of the user who owns this MESSAGE
)
    private Restaurant reviewsAt;
}
