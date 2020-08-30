package com.sda.service;

import com.sda.dto.CreateProductDto;
import com.sda.dto.EditProductDto;
import com.sda.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    void saveProduct (CreateProductDto createProductDTO);

    void deleteProductById (Integer id);

    void editProductById (Integer id, EditProductDto editProductDto);

    List<Product> findAll ();

    Optional<Product> findProductById (Integer id);

    List<Product> filterProductByPrice (Integer priceLower, Integer priceHigher);

    List<Product> findByFilters (String name, String description);

    List<Product> getAllByNameOrDescrition(String name, String description);
}
