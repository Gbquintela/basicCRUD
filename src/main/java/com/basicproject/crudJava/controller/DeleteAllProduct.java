package com.basicproject.crudJava.controller;


import com.basicproject.crudJava.service.DeleteAllService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Indica que esta classe é um controlador REST que retorna respostas no formato JSON/XML
@RestController
// Mapeia todas as requisições que começam com "/products" para este controlador
@RequestMapping("/products")
public class DeleteAllProduct {

    private final DeleteAllService deleteAllService;


    public DeleteAllProduct(DeleteAllService deleteAllService) {
        this.deleteAllService = deleteAllService;
    }

    @DeleteMapping("/delete/all")
    public ResponseEntity<?> deleteAllProducts(){
        boolean deleted = deleteAllService.deleteAllProducts();

        if(deleted){
            return ResponseEntity.ok("Todos produtos foram deletados!");
        } else {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum produto encontrado para deletar");
        }

    }
}
