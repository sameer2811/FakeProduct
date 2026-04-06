package com.example.FakeCommerceApp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.FakeCommerceApp.DTO.GetReviewDto;
import com.example.FakeCommerceApp.repository.ProductRepository;
import com.example.FakeCommerceApp.repository.ReviewRepository;
import com.example.FakeCommerceApp.schema.Product;
import com.example.FakeCommerceApp.schema.Review;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final ProductRepository productRepository;

    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    public Review createReview(GetReviewDto reviewDto) {
        Product product = productRepository.findById(reviewDto.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));
        Review review = Review.builder()
                .comment(reviewDto.getComment())
                .rating(reviewDto.getRating())
                .product(product)
                .build();
        return reviewRepository.save(review);
    }

    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }

    public Review getReviewById(Long id) {
        return reviewRepository.findById(id).orElseThrow(() -> new RuntimeException("No value present"));
    }

    public List<Review> getReviewsByProductId(Long productId) {
        return reviewRepository.findByProductId(productId);
    }
}
