package com.sda.repository;

import com.sda.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductServiceRepository extends JpaRepository<Product, Integer> {

    List<Product> findAllByNameAndDescription(String name, String description);
    List<Product> findAllByPriceBetween(Integer minPrice, Integer maxPrice);
    List<Product> findAllByName(String name);
    List<Product> findAllByNameOrDescription(String name, String description);
}
