package com.basicproject.crudJava.service;


import com.basicproject.crudJava.entity.Product;
import com.basicproject.crudJava.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

//Anotaçaão para representar que uma classe de serviço
@Service
public class DeleteAllService {

    private final ProductRepository productRepository;


    public DeleteAllService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }




    public boolean deleteAllProducts(){
        List<Product> existingProducts = this.productRepository.findAll();
        if(existingProducts.isEmpty()){

            return  false;

        }
        productRepository.deleteAll();
        return true;

    }


}
