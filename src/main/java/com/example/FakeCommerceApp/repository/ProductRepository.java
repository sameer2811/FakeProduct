package com.example.FakeCommerceApp.repository;

import com.example.FakeCommerceApp.schema.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findProductByCategory(String categoryName);

    /**
     * Derived {@code findDistinctCategoryBy()} is interpreted as distinct {@link Product} rows,
     * not a {@code String} projection — Spring then fails converting Product → String.
     * JPQL must select the column explicitly for {@code List<String>}.
     */
    @Query("select distinct p.category from Product p where p.category is not null")
    List<String> findDistinctCategoryBy();
}
