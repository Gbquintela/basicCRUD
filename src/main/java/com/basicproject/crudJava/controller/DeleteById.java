package com.basicproject.crudJava.controller;

import com.basicproject.crudJava.service.DeleteByIdService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Controlador REST para operações de exclusão de produtos por ID.
@RestController
// Define o caminho base para as requisições deste controlador como "/products".
@RequestMapping("/products")
public class DeleteById {

    private final DeleteByIdService deleteByIdService;

    // Injeção de dependência do serviço responsável por deletar produtos por ID.
    public DeleteById(DeleteByIdService deleteByIdService) {
        this.deleteByIdService = deleteByIdService;
    }

    // Endpoint para deletar um produto específico através de uma requisição HTTP DELETE em "/products/delete/{id}", onde {id} é o ID do produto a ser deletado.
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable Long id){
        // Chama o serviço para executar a lógica de exclusão do produto com o ID fornecido.
        if(deleteByIdService.deleteProductById(id)){
            // Se a exclusão for bem-sucedida, retorna uma resposta HTTP 200 (OK) com uma mensagem de sucesso.
            return  ResponseEntity.ok("Produto deletado com sucesso");
        }

        // Se o produto com o ID fornecido não for encontrado, retorna uma resposta HTTP 404 (NOT_FOUND) com uma mensagem de erro.
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
    }
}