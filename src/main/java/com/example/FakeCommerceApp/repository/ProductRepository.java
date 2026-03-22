package com.example.FakeCommerceApp.repository;

import com.example.FakeCommerceApp.schema.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findProductByCategory(String categoryName);

    @Query("select distinct p.category from Product p where p.category is not null")
    List<String> findDistinctCategoryBy();
}
