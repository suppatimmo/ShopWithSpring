package com.sda.dto;

import lombok.Data;

@Data
public class EditProductDto {
    //DTO - Data Transfer Object

    private Integer price;
    private Integer quantity;
    private String description;
    private String imageUrl;
}
