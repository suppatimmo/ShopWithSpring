package com.sda.controller;

import com.sda.dto.CreateProductDto;
import com.sda.dto.EditProductDto;
import com.sda.model.Product;
import com.sda.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductRepository productRepository;

    //warstwa serwisu
    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CreateProductDto productDto) {
        productRepository.saveProduct(productDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteById(@RequestParam Integer id) {
        productRepository.deleteProductById(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @PutMapping("/{productId}")
    public ResponseEntity<Product> update(@PathVariable Integer productId,
                                        @RequestBody EditProductDto editProductDto) {
        productRepository.editProductById(productId, editProductDto);
        System.out.println(productId);
        return ResponseEntity.ok(productRepository.findProductById(productId).get());
    }
    @GetMapping(value = "/all")
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok(productRepository.findAll());
    }

    @GetMapping
    public ResponseEntity<Product> findById(@RequestParam Integer id) {
        return ResponseEntity.ok(productRepository.findProductById(id)
                .orElse(null));
    }

}
