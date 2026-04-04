package com.example.FakeCommerceApp.service;

import com.example.FakeCommerceApp.DTO.GetCompleteProductResponseDetailsDto;
import com.example.FakeCommerceApp.DTO.ProductDto;
import com.example.FakeCommerceApp.repository.ProductRepository;
import com.example.FakeCommerceApp.schema.Category;
import com.example.FakeCommerceApp.schema.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("No value present"));
    }

    public Product create(ProductDto productDto) {

        Category category = categoryService.findById(productDto.getCategoryId());
        Product product = Product.builder()
                .id(productDto.getId())
                .name(productDto.getName())
                .price(productDto.getPrice())
                .category(category)
                .description(productDto.getDescription())
                .quantity(productDto.getQuantity())
                .build();
        return productRepository.save(product);
    }

    public void delete(Long productId) {
        productRepository.deleteById(productId);
    }

    public List<String> findAllDistinctCategory() {
        return productRepository.findDistinctCategoryBy();
    }

    public List<Product> findByCategory(String category) {
        return productRepository.findProductByCategory(category);
    }

    public GetCompleteProductResponseDetailsDto findCompleteProductDetails(Long productId) {
        Optional<Product> product = productRepository.findProductByCompleteDetails(productId);
        if (product.isPresent()) {
            Product productEntity = product.get();
            return GetCompleteProductResponseDetailsDto.builder()
                    .id(productEntity.getId())
                    .name(productEntity.getName())
                    .description(productEntity.getDescription())
                    .price(productEntity.getPrice())
                    .quantity(productEntity.getQuantity())
                    .categoryName(productEntity.getCategory().getName())
                    .build();
        }
        return null;
    }
}
