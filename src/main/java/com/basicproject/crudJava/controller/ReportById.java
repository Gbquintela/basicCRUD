package com.basicproject.crudJava.controller;


import com.basicproject.crudJava.entity.Product;
import com.basicproject.crudJava.service.ReportByIdService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ReportById {



    private final ReportByIdService reportByIdService;

    public ReportById( ReportByIdService reportByIdService) {

        this.reportByIdService = reportByIdService;
    }

    @GetMapping("/reportById/{id}")
    public ResponseEntity<?> reportById(@PathVariable long id){
        Optional<Product> product = reportByIdService.getProductById(id);

        if(product.isPresent()){

            return  ResponseEntity.ok(product.get());

        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

