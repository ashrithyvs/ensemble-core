package com.ensemble.ensemble_core.repository;

import com.ensemble.ensemble_core.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    @Query("From Reviews r Where r.reviewsAt.restaurantId=:restaurantId")
    List<Review> findReviewsByReviewsAt(int restaurantId);
}
