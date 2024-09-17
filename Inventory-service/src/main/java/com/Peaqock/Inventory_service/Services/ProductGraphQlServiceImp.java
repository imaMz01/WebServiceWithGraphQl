package com.Peaqock.Inventory_service.Services;

import com.Peaqock.Inventory_service.Dtos.ProductRequestDto;
import com.Peaqock.Inventory_service.Entities.Category;
import com.Peaqock.Inventory_service.Entities.Product;
import com.Peaqock.Inventory_service.Repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductGraphQlServiceImp implements  ProductGraphQlService{

    private final ProductRepository productRepository;
    public final CategoryGraphQlService categoryGraphQlService;

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
    public Product add(ProductRequestDto product) {
        Product productToSave = new Product();
        Category category = categoryGraphQlService.categoryById(product.getCategoryId());
        productToSave.setId(UUID.randomUUID().toString());
        productToSave.setName(product.getName());
        productToSave.setPrice(product.getPrice());
        productToSave.setQuantity(product.getQuantity());
        productToSave.setCategory(category);
        return productRepository.save(productToSave);
    }

    @Override
    public Product update(ProductRequestDto productRequestDto,String id) {
        Product productToSave = productById(id);
        Category category = categoryGraphQlService.categoryById(productRequestDto.getCategoryId());
        //productToSave.setId(productRequestDto.getId());
        productToSave.setName(productRequestDto.getName());
        productToSave.setPrice(productRequestDto.getPrice());
        productToSave.setQuantity(productRequestDto.getQuantity());
        productToSave.setCategory(category);
        return productRepository.save(productToSave);
    }

    @Override
    public void delete(String id) {
        productRepository.deleteById(id);
    }

}
