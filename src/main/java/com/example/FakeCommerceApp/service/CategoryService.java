package com.example.FakeCommerceApp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.FakeCommerceApp.DTO.CategoryDto;
import com.example.FakeCommerceApp.repository.CategoryRepository;
import com.example.FakeCommerceApp.schema.Category;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("No value present"));
    }

    public Category create(CategoryDto categoryDto) {
        Category category = Category.builder()
                .name(categoryDto.getName())
                .build();
        return categoryRepository.save(category);
    }
}
