package com.ensemble.ensemble_core.service;

import com.ensemble.ensemble_core.model.Review;

import java.util.List;

public interface ReviewService {
     String addReview(Review review);
     List<Review> getReviewsByRestaurantId(int restaurantId);
}
