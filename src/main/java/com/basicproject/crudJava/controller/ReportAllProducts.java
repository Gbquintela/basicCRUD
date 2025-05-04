package com.basicproject.crudJava.controller;


import com.basicproject.crudJava.entity.Product;
import com.basicproject.crudJava.repository.ProductRepository;
import com.basicproject.crudJava.service.ReportAllService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ReportAllProducts {

    private final ProductRepository productRepository;
    private final ReportAllService reportAllService;


    public ReportAllProducts(ProductRepository productRepository, ReportAllService reportAllService) {
        this.productRepository = productRepository;
        this.reportAllService = reportAllService;
    }

    @GetMapping("/reportAll")
    public ResponseEntity<?> reportAllProducts() {
        try {
            List<Product> products = reportAllService.getAllProducts();

            if (products.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum produto encontrado");
            }
            return ResponseEntity.ok(products);
        } catch (Exception e){

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error ao buscar produtos " + e.getMessage());

        }    }
}
