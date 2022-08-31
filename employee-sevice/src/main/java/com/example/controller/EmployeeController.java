package com.example.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @GetMapping("/employee")
    public ResponseEntity<?> getDetails() {
        //TODO
        return new ResponseEntity<>("this is employee service", HttpStatus.OK);
    }
}
