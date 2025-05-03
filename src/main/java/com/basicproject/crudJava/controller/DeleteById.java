package com.basicproject.crudJava.controller;


import com.basicproject.crudJava.service.DeleteAllService;
import com.basicproject.crudJava.service.DeleteByIdService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class DeleteById {

    private final DeleteByIdService deleteByIdService;


    public DeleteById(DeleteByIdService deleteByIdService) {
        this.deleteByIdService = deleteByIdService;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable Long id){
        if(deleteByIdService.deleteProductById(id)){
            return  ResponseEntity.ok("Produto deletado com sucesso");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");

    }

}
