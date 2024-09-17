package com.Peaqock.Inventory_service.Services;

import com.Peaqock.Inventory_service.Entities.Category;

import java.util.List;

public interface CategoryGraphQlService {

    public List<Category> list();
    public Category categoryById(Long id);
}
