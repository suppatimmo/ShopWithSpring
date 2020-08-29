package com.sda.controller;

import com.sda.model.HelloWorld;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/home")
public class HomeController {

//    @GetMapping
//    public ResponseEntity<HelloWorld> test() {
//        HelloWorld helloWorld = HelloWorld.builder()
//                .string("Hello World")
//                .build();
//        return ResponseEntity.ok(helloWorld);
//    }

    @GetMapping("/home")
    public String hello() {
        return "Hello World!";
    }
}
