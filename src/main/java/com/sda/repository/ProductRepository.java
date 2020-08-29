package com.sda.repository;

import com.sda.model.Product;

import java.util.Optional;

public interface ProductRepository {

    void saveProduct (CreateProductDTO createProductDTO);

    void deleteProductById (Integer id);

    void editProductById (Integer id);

    Optional<Product> findProductById (Integer id);

    List<Product> findAll();

}
