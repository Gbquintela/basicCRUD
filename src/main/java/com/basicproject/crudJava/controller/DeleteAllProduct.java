package com.basicproject.crudJava.controller;

import com.basicproject.crudJava.service.DeleteAllService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Controlador REST para operações relacionadas à exclusão de todos os produtos.
@RestController
// Define o caminho base para as requisições deste controlador como "/products".
@RequestMapping("/products")
public class DeleteAllProduct {

    private final DeleteAllService deleteAllService;

    // Injeção de dependência do serviço responsável por deletar todos os produtos.
    public DeleteAllProduct(DeleteAllService deleteAllService) {
        this.deleteAllService = deleteAllService;
    }

    // Endpoint para deletar todos os produtos através da requisição HTTP DELETE em "/products/delete/all".
    @DeleteMapping("/delete/all")
    public ResponseEntity<?> deleteAllProducts(){
        // Chama o serviço para executar a lógica de exclusão de todos os produtos.
        boolean deleted = deleteAllService.deleteAllProducts();

        // Verifica se a exclusão foi bem-sucedida e retorna a resposta apropriada.
        if(deleted){
            // Retorna uma resposta HTTP 200 (OK) com uma mensagem de sucesso.
            return ResponseEntity.ok("Todos produtos foram deletados!");
        } else {
            // Retorna uma resposta HTTP 404 (NOT_FOUND) com uma mensagem indicando que nenhum produto foi encontrado para deletar.
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum produto encontrado para deletar");
        }
    }
}