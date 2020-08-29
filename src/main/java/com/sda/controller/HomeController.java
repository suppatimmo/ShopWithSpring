package com.sda.controller;

import com.sda.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

    @GetMapping
    public ResponseEntity<Product> test() {
        Product product = Product.builder()
                .price(14)
                .quantity(25)
                .name("pendrive 8GB")
                .description("portable cache")
                .imageUrl("http://pendriveusb24.pl/wp-content/uploads/44026.jpg")
                .build();

        return ResponseEntity.ok(product);
    }

//    @GetMapping
//    public ResponseEntity<HelloWorld> test() {
//        HelloWorld helloWorld = HelloWorld.builder()
//                .string("Hello World")
//                .build();
//        return ResponseEntity.ok(helloWorld);
//    }

//    @GetMapping("/home")
//    public String hello() {
//        return "Hello World!";
//    }
}
