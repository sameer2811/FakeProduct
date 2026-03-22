package com.example.FakeCommerceApp.controller;

import com.example.FakeCommerceApp.DTO.ProductDto;
import com.example.FakeCommerceApp.DTO.GetProductResponseDto;
import com.example.FakeCommerceApp.schema.Product;
import com.example.FakeCommerceApp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    // here we are using the GetProductResponseDto to return the product details
    // since the category is a lazy loaded entity, we are not fetching it here.
    // if we want to fetch the category details, we can do it by calling the
    // findById method.
    // but since the return type is GetProductResponseDto, we are not fetching the
    // category details here.
    @GetMapping
    List<GetProductResponseDto> findAllProducts() {
        List<Product> products = productService.findAll();
        List<GetProductResponseDto> response = products.stream().map(product -> GetProductResponseDto.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .build()).collect(Collectors.toList());
        return response;
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
    List<Product> findByCategory(@RequestParam(value = "categoryName") String categoryName,
            @RequestParam(value = "quantity", required = false) Integer quantity) {
        return productService.findByCategory(categoryName);
    }

    @GetMapping("/distinct")
    List<String> findAllDistinctCategory() {
        return productService.findAllDistinctCategory();
    }

    @GetMapping("/{prodId}")
    // This method is used to find a product by its id
    // on calling this method the product will be fetched
    // the call to fetch the category will be there since the return type is Product
    // hence there is no benifit of lazy loading here.
    Product findById(@PathVariable("prodId") Long productId) {
        return productService.findById(productId);
    }
}
