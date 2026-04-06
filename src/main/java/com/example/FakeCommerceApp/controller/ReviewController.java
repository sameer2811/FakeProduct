package com.example.FakeCommerceApp.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.FakeCommerceApp.DTO.GetReviewResponseDto;
import com.example.FakeCommerceApp.schema.Review;
import com.example.FakeCommerceApp.service.ReviewService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/review")
@AllArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping
    public List<GetReviewResponseDto> getAllReviews() {
        return reviewService.findAll().stream().map(review -> GetReviewResponseDto.builder()
                .id(review.getId())
                .comment(review.getComment())
                .rating(review.getRating())
                .productId(review.getProduct().getId())
                .createdAt(review.getCreatedAt())
                .build()).filter(review -> review != null).collect(Collectors.toList());
    }

    @PostMapping
    public Review createReview(@RequestBody Review review) {
        if(review.getRating() < 1 || review.getRating() > 5) {
            throw new RuntimeException("Rating must be between 1 and 5");
        }
        if(review.getComment().isEmpty()) {
            throw new RuntimeException("Comment is required");
        }
        return reviewService.createReview(review);
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
    }

    @GetMapping("/{id}")
    public GetReviewResponseDto getReviewById(@PathVariable Long id) {
        Review review = reviewService.getReviewById(id);
        return GetReviewResponseDto.builder()
                .id(review.getId())
                .comment(review.getComment())
                .rating(review.getRating())
                .productId(review.getProduct().getId())
                .createdAt(review.getCreatedAt())
                .build();
    }

    @GetMapping("/product/{productId}")
    public List<GetReviewResponseDto> getReviewsByProductId(@PathVariable Long productId) {
        List<Review> reviews = reviewService.getReviewsByProductId(productId);
        return reviews.stream().map(review -> GetReviewResponseDto.builder()
                .id(review.getId())
                .comment(review.getComment())
                .rating(review.getRating())
                .productId(review.getProduct().getId())
                .createdAt(review.getCreatedAt())
                .build()).collect(Collectors.toList());
    }
}
