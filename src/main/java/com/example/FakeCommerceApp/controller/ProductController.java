package com.example.FakeCommerceApp.controller;

import com.example.FakeCommerceApp.DTO.ProductDto;
import com.example.FakeCommerceApp.schema.Product;
import com.example.FakeCommerceApp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    List<Product> findAllProducts() {
        return productService.findAll();
    }

    @PostMapping
    Product createProduct(@RequestBody ProductDto productDto) {
        return productService.create(productDto);
    }

    @DeleteMapping("/{prodId}")
    public void delete(@PathVariable("prodId") Long productId) {
        System.out.println(productId);
        productService.delete(productId);
    }

    @GetMapping("/filter")
    List<Product> findByCategory(@RequestParam(value = "categoryName") String categoryName, @RequestParam(value = "quantity", required = false) Integer quantity) {
        return productService.findByCategory(categoryName);
    }

    @GetMapping("/distinct")
    List<String> findAllDistinctCategory() {
        return productService.findAllDistinctCategory();
    }
}
