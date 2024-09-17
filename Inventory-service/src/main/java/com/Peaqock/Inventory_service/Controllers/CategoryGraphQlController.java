package com.Peaqock.Inventory_service.Controllers;

import com.Peaqock.Inventory_service.Entities.Category;
import com.Peaqock.Inventory_service.Services.CategoryGraphQlService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CategoryGraphQlController {

    private final CategoryGraphQlService categoryGraphQlService;

    @QueryMapping
    public List<Category> allCategories(){
       return categoryGraphQlService.list();
    }

    @QueryMapping
    public Category categoryById(@Argument Long id){
        return categoryGraphQlService.categoryById(id);
    }
}
