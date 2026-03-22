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

    public Category create(CategoryDto categoryDto) {
        Category category = Category.builder()
                .id(categoryDto.getId())
                .name(categoryDto.getName())
                .build();
        return categoryRepository.save(category);
    }
}
