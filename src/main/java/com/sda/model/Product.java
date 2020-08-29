package com.sda.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Product {

    private Integer id;
    private Integer price;
    private Integer quantity;
    private String name;
    private String description;
    private String imageUrl;
}
