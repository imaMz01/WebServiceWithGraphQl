package com.Peaqock.Inventory_service.Controller;


import com.Peaqock.Inventory_service.Entities.Product;
import com.Peaqock.Inventory_service.Repositories.ProductRepository;
import com.Peaqock.Inventory_service.Service.ProductGraphQlService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductGraphQlController {

    public final ProductGraphQlService productGraphQlService;

    @QueryMapping
    public List<Product> allProducts(){
        return productGraphQlService.list();
    }

    @QueryMapping
    public  Product productById(@Argument String id){
        return productGraphQlService.productById(id);
    }
}
