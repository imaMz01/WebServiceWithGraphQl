package com.Peaqock.Inventory_service.Services;

import com.Peaqock.Inventory_service.Entities.Product;
import com.Peaqock.Inventory_service.Repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductGraphQlServiceImp implements  ProductGraphQlService{

    private final ProductRepository productRepository;

    public List<Product> list(){
        return productRepository.findAll();
    }

    @Override
    public Product productById(String id) {
        return productRepository.findById(id).orElseThrow(
                ()-> new RuntimeException(String.format("Product with %s not found",id))
                );
    }

    @Override
    public Product add(Product product) {
        return productRepository.save(product);
    }
}
