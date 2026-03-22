package com.example.FakeCommerceApp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.FakeCommerceApp.DTO.CategoryDto;
import com.example.FakeCommerceApp.schema.Category;
import com.example.FakeCommerceApp.service.CategoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class categoryController {
    private final CategoryService categoryService;

    @GetMapping
    List<Category> findAllCategories() {
        return categoryService.findAll();
    }

    @PostMapping
    Category createCategory(@RequestBody CategoryDto categoryDto) {
        return categoryService.create(categoryDto);
    }
}
