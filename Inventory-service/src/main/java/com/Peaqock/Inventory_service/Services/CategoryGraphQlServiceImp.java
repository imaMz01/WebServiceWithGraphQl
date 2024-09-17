package com.Peaqock.Inventory_service.Services;

import com.Peaqock.Inventory_service.Entities.Category;
import com.Peaqock.Inventory_service.Repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryGraphQlServiceImp implements CategoryGraphQlService{

    private final CategoryRepository categoryRepository;
    @Override
    public List<Category> list() {
        return categoryRepository.findAll();
    }

    @Override
    public Category categoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow(
                ()-> new RuntimeException(String.format("Category with id %s not found",id))
        );
    }
}
