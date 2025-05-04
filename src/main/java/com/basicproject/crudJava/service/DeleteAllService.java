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

    // Repositório de produtos (interface que faz comunicação com o banco de dados)
    private final ProductRepository productRepository;

    // Construtor com injeção de dependência do repositório
    public DeleteAllService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }



    public boolean deleteAllProducts() {
        // Busca todos os produtos existentes no banco
        List<Product> existingProducts = this.productRepository.findAll();

        // Verifica se a lista de produtos está vazia
        if(existingProducts.isEmpty()) {
            // Retorna false se não houver produtos para deletar
            return false;
        }

        // Deleta todos os produtos do banco de dados
        productRepository.deleteAll();

        // Retorna true indicando que a operação foi bem sucedida
        return true;
    }
}
