package com.Peaqock.Inventory_service.Repositories;

import com.Peaqock.Inventory_service.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,String> {
}
