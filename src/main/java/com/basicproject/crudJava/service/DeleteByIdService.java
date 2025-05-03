package com.basicproject.crudJava.service;


import com.basicproject.crudJava.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteByIdService {

    private final ProductRepository productRepository;


    public DeleteByIdService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public boolean deleteProductById(Long id){

        if(productRepository.existsById(id)){
            productRepository.deleteById(id);
            return true;
        }
            return false;
    }
}
