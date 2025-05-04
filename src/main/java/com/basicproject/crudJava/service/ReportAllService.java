package com.basicproject.crudJava.service;


import com.basicproject.crudJava.entity.Product;
import com.basicproject.crudJava.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportAllService {

    private final ProductRepository productRepository;


    public ReportAllService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Metodo para mostrar todos os produtos

     */
    public List<Product> getAllProducts(){
        //Retorna todos os produtos cadastrados
        return productRepository.findAll();
    }
}
