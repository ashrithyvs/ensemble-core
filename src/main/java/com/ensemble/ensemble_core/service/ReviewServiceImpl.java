package com.ensemble.ensemble_core.service;

import com.ensemble.ensemble_core.model.Review;
import com.ensemble.ensemble_core.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService{

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public String addReview(Review review) {
        try {
            reviewRepository.save(review);
            return "Review Added Successfully";
        }catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public List<Review> getReviewsByRestaurantId(int restaurantId) {
        return reviewRepository.findReviewsByReviewsAt(restaurantId);
    }
}
