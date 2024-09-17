package com.Peaqock.Inventory_service.Dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDto {
    private String id;
    private String name;
    private double price;
    private int quantity;
    private Long categoryId;
}
