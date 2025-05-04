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

    // Metodo para atualizar um produto existente com base no ID e nos dados fornecidos.
    public void updateProduct(Long id, Product productUpdate){
        // Busca o produto existente pelo ID.
        Optional<Product> productOptional = productRepository.findById(id);
        // Obtém o produto existente do Optional. Assume-se que o produto existe.
        Product productExist = productOptional.get();

        //Atualiza os dados fornecidos
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
