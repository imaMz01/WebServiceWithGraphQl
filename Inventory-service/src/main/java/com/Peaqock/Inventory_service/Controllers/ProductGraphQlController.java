package com.Peaqock.Inventory_service.Controllers;


import com.Peaqock.Inventory_service.Dtos.ProductRequestDto;
import com.Peaqock.Inventory_service.Entities.Category;
import com.Peaqock.Inventory_service.Entities.Product;
import com.Peaqock.Inventory_service.Services.CategoryGraphQlService;
import com.Peaqock.Inventory_service.Services.ProductGraphQlService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class ProductGraphQlController {

    public final ProductGraphQlService productGraphQlService;
    public final CategoryGraphQlService categoryGraphQlService;

    @QueryMapping
    public List<Product> allProducts(){
        return productGraphQlService.list();
    }

    @QueryMapping
    public Product productById(@Argument String id){
        return productGraphQlService.productById(id);
    }

    @MutationMapping
    public Product addProduct(@Argument ProductRequestDto product){
        Product productToSave = new Product();
        Category category = categoryGraphQlService.categoryById(product.getCategoryId());
        productToSave.setId(UUID.randomUUID().toString());
        productToSave.setName(product.getName());
        productToSave.setPrice(product.getPrice());
        productToSave.setQuantity(product.getQuantity());
        productToSave.setCategory(category);
        return productGraphQlService.add(productToSave);
    }
}
