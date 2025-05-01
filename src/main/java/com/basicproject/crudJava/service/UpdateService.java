package com.basicproject.crudJava.service;


import com.basicproject.crudJava.entity.Product;
import com.basicproject.crudJava.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

//Anotaçaão para representar que uma classe de serviço
@Service
public class UpdateService {
    private final ProductRepository  productRepository;


    public UpdateService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public void updateProduct(Long id, Product productUpdate){

        Optional<Product> productOptional = productRepository.findById(id);

        Product productExist = productOptional.get();

        if(productUpdate.getProductName() != null){
            productExist.setProductName(productUpdate.getProductName());
        }
        if(productUpdate.getTypeProduct() != null){
            productExist.setTypeProduct(productUpdate.getTypeProduct());
        }
        if(productUpdate.getProductPrice() != null){
            productExist.setProductPrice(productUpdate.getProductPrice());
        }
        if(productUpdate.getQuantityOfProduct() != null){
            productExist.setQuantityOfProduct(productUpdate.getQuantityOfProduct());

        }

        if(productUpdate.getDescriptionOfProduct() != null){
            productExist.setDescriptionOfProduct(productUpdate.getDescriptionOfProduct());
        } else {
            throw  new RuntimeException("produto não encontrado ");
        }


    }
}
