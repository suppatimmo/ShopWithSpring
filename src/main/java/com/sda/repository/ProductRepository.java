package com.sda.repository;

import com.sda.dto.CreateProductDto;
import com.sda.dto.EditProductDto;
import com.sda.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    void saveProduct (CreateProductDto createProductDTO);

    void deleteProductById (Integer id);

    void editProductById (Integer id, EditProductDto editProductDto);

    List<Product> findAll();

    Optional<Product> findProductById (Integer id);

}
