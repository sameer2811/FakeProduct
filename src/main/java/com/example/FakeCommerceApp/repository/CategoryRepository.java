package com.example.FakeCommerceApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.FakeCommerceApp.schema.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    
}
