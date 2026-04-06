package com.example.FakeCommerceApp.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.FakeCommerceApp.schema.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByProductId(Long productId);
}
