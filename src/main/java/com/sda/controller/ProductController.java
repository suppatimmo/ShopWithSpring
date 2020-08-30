package com.sda.controller;

import com.sda.dto.CreateProductDto;
import com.sda.dto.EditProductDto;
import com.sda.model.Product;
import com.sda.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService service;

    //warstwa serwisu
    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Void> create(@RequestBody CreateProductDto productDto) {
        service.saveProduct(productDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteById(@RequestParam Integer id) {
        service.deleteProductById(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @PutMapping("/{productId}")
    public ResponseEntity<Product> edit(@PathVariable Integer productId,
                                        @RequestBody EditProductDto editProductDto) {
        service.editProductById(productId, editProductDto);
        System.out.println(productId);
        return ResponseEntity.ok(service.findProductById(productId).get());

//        return ResponseEntity.ok(productRepository.editProductById(productId, editProductDto).orElse(null));
    }
    @GetMapping(value = "/all")
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping
    public ResponseEntity<Product> findById(@RequestParam Integer id) {
        return ResponseEntity.ok(service.findProductById(id)
                .orElse(null));
    }

    @GetMapping(value = "/price")
    public ResponseEntity<List<Product>> filterByPrice(@RequestParam Integer priceLower,
                                                       @RequestParam Integer priceHigher) {
        return ResponseEntity.ok(service.filterProductByPrice(priceLower, priceHigher));
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Product>> findProducts (@RequestParam (required = false) String name,
                                                       @RequestParam (required = false) String description) {
        List<Product> byFilters = service.findByFilters(name, description);
        return ResponseEntity.ok(byFilters);
    }

    @GetMapping(value = "/nameor")
    @ResponseBody
    public ResponseEntity<List<Product>> getAllByNameOrDescription(@RequestParam(required = false) String name,
                                                                   @RequestParam(required = false) String description) {
        return ResponseEntity.ok(service.getAllByNameOrDescrition(name, description));
    }

}
