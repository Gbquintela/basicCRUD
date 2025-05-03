package com.basicproject.crudJava.service;

import com.basicproject.crudJava.dto.ProductDTORequest;
import com.basicproject.crudJava.dto.ProductDTOResponse;
import com.basicproject.crudJava.entity.Product;
import com.basicproject.crudJava.repository.ProductRepository;
import org.springframework.stereotype.Service;

//Anotaçaão para representar que uma classe de serviço
@Service
public class CreateService {

    private final ProductRepository productRepository;


    public CreateService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public ProductDTOResponse createProduct(ProductDTORequest request){
        Product product = request.toProduct();
        Product productCreated = productRepository.save(product);
        return ProductDTOResponse.fromProduct(productCreated);
    }

}
