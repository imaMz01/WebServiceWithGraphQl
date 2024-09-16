package com.Peaqock.Inventory_service.Service;

import com.Peaqock.Inventory_service.Entities.Product;

import java.util.List;

public interface ProductGraphQlService {

    public List<Product> list();
    public Product productById(String id);
}
