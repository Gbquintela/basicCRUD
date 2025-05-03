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

    public ResponseEntity<String> deleteAllProducts(){

        //Faço uma busca por todos os produtos cadastrados
        List<Product> existingProduct = this.productRepository.findAll();

        //Verificação se a lista esta vazia, Se vazia retorna um erro
        if(existingProduct.isEmpty()){

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Nenhum Produto encontrado.");
        }

        //Caso esteja com algum produto cadastrado, executo o metodo de exclusão de todos  os produtos
        productRepository.deleteAll();

        //Retorno valor de sucesso 200.
        return ResponseEntity.ok().body("Todos os produtos foram deletados!");
    }


}
