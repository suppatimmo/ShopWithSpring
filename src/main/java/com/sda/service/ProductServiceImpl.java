package com.sda.service;

import com.sda.dto.CreateProductDto;
import com.sda.dto.EditProductDto;
import com.sda.model.Product;
import com.sda.repository.ProductServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductServiceRepository repository;

    @Override
    public void saveProduct(CreateProductDto createProductDTO) {
        Product product = Product.builder()
                .price(createProductDTO.getPrice())
                .quantity(createProductDTO.getQuantity())
                .name(createProductDTO.getName())
                .description(createProductDTO.getDescription())
                .imageUrl(createProductDTO.getImageUrl())
                .build();

        repository.save(product);
    }

    @Override
    public void deleteProductById(Integer id) {
        repository.deleteById(id);

    }

    @Override
    public void editProductById(Integer id, EditProductDto editProductDto) {
        Optional<Product> product = repository.findById(id);
        if (product.isEmpty())
            return;

        //get zwraca obiekt z wrappera
        Product p = product.get();
        if (editProductDto.getDescription() != null && !editProductDto.getDescription().isEmpty())
            p.setDescription(editProductDto.getDescription());

        if (editProductDto.getImageUrl() != null && !editProductDto.getImageUrl().isEmpty())
            p.setImageUrl(editProductDto.getImageUrl());

        if (editProductDto.getPrice() != null)
            p.setPrice(editProductDto.getPrice());

        if (editProductDto.getQuantity() != null)
            p.setQuantity(editProductDto.getQuantity());

        repository.save(p);

    }

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Product> findProductById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public List<Product> filterProductByPrice(Integer priceLower, Integer priceHigher) {
        return null;
    }

    @Override
    public List<Product> findByFilters(String name, String description) {
        return null;
    }

    @Override
    public List<Product> getAllByNameOrDescrition(String name, String description) {
        return repository.findAllByNameOrDescription(name, description);
    }

//    @Override
//    public List<Product> findByFilters(String name, String description) {
////        Set<Product> filteredProducts = new HashSet<>(repository.findAll());
////
////        if (name != null) {
////            filteredProducts.removeIf(product -> !product.getName().contains(name));
////        }
////
////        if (description != null) {
////            filteredProducts.removeIf(product -> !product.getDescription().contains(description));
////        }
////
////        if (price != null) {
////            filteredProducts.removeIf(product -> !product.getPrice().equals(price));
////        }
////
////        return filteredProducts;
////    }
//    }


}
