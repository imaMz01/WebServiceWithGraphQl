package com.Peaqock.Inventory_service;

import com.Peaqock.Inventory_service.Entities.Category;
import com.Peaqock.Inventory_service.Entities.Product;
import com.Peaqock.Inventory_service.Repositories.CategoryRepository;
import com.Peaqock.Inventory_service.Repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	/*@Bean
	CommandLineRunner commandeLineRunner(ProductRepository productRepository,
										 CategoryRepository categoryRepository) {
		Random random=new Random();
		return args -> {
			List.of("Computer", "Printer").forEach(cat -> {
				Category category = Category.builder()
						.name(cat)
						.build();
				categoryRepository.save(category);
			});
			categoryRepository.findAll().forEach( category -> {
				for (int i = 0; i < 10; i++) {
					Product product = Product.builder()
							.id(UUID.randomUUID().toString())
							.name("Product "+i)
							.quantity(random.nextInt(100))
							.price(100 + Math.random()*200)
							.category(category)
							.build();
					productRepository.save(product);
				}
			});
		};
	}*/
}
