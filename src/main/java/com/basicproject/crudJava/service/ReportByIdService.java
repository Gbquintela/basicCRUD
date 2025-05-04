package com.basicproject.crudJava.service;


import com.basicproject.crudJava.entity.Product;
import com.basicproject.crudJava.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportByIdService {

    private final ProductRepository productRepository;


    public ReportByIdService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    /**
     * Metodo para mostrar todos os produtos pelo id

     */
    public Optional<Product> getProductById(Long id){

        //Retorna todos os produtos pelo id
        return productRepository.findById(id);

    }


}
