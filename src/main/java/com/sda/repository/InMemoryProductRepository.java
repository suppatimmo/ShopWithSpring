package com.sda.repository;

import com.sda.dto.CreateProductDto;
import com.sda.dto.EditProductDto;
import com.sda.model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class InMemoryProductRepository implements ProductRepository {

    private static List<Product> products;

    private static AtomicInteger idCounter;

    public InMemoryProductRepository() {
    products = new ArrayList<>();
    idCounter = new AtomicInteger(1);
    }

    @Override
    public void saveProduct(CreateProductDto createProductDTO) {
        Product product = Product.builder()
                .id(idCounter.getAndIncrement())
                .price(createProductDTO.getPrice())
                .quantity(createProductDTO.getQuantity())
                .name(createProductDTO.getName())
                .description(createProductDTO.getDescription())
                .imageUrl(createProductDTO.getImageUrl())
                .build();

        products.add(product);
    }

    @Override
    public void deleteProductById(Integer id) {
        products.removeIf(product -> product.getId().equals(id));
    }

    @Override
    public void editProductById(EditProductDto editProductDto) {


    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Optional<Product> findProductById(Integer id) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst();
    }
}
