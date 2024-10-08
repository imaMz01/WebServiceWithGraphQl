package com.Peaqock.Inventory_service.Services;

import com.Peaqock.Inventory_service.Dtos.ProductRequestDto;
import com.Peaqock.Inventory_service.Entities.Product;

import java.util.List;

public interface ProductGraphQlService {

    public List<Product> list();
    public Product productById(String id);
    public Product add(ProductRequestDto productRequestDto);
    public Product update(ProductRequestDto productRequestDto,String id);
    public void delete(String id);
}
