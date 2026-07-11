package com.cts.security.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {
 
    @GetMapping("/hello")
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello! You have accessed a secured endpoint.");
    }
    
    @GetMapping("/hai")
    public ResponseEntity<String> sayHai() {
        return ResponseEntity.ok("Hai! You have accessed a secured endpoint.");
    }
}