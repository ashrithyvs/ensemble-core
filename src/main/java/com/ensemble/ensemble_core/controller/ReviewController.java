package com.ensemble.ensemble_core.controller;

import com.ensemble.ensemble_core.model.Review;
import com.ensemble.ensemble_core.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
@CrossOrigin
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public String addReview(@RequestBody Review review){
        return reviewService.addReview(review);
    }

    @GetMapping(("/{restaurantId}"))
    public List<Review> getReviewsByRestaurantId(@PathVariable("restaurantId") int restaurantId){
        return reviewService.getReviewsByRestaurantId(restaurantId);
    }
}
