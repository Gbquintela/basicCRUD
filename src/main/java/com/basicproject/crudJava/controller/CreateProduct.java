package com.basicproject.crudJava.controller;


import com.basicproject.crudJava.dto.ProductDTORequest;
import com.basicproject.crudJava.dto.ProductDTOResponse;
import com.basicproject.crudJava.entity.Product;
import com.basicproject.crudJava.repository.ProductRepository;
import com.basicproject.crudJava.service.CreateService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/product")

public class CreateProduct {
    private final CreateService createService;

    public CreateProduct(CreateService createProduct) {
        this.createService = createProduct;
    }


    //Rota para cadastro do produto
@PostMapping("/create")

//Passando os DTOS para verificar a informação e confirmaçãos dos dados
public ResponseEntity<?> createProduct(@RequestBody @Valid ProductDTORequest request, BindingResult result){

    //Laço para verificar erros de inserções conforme os dados preenchidos
    //Caso contenha um erro a variavel 'Result' retorna um erro compativel.
    if(result.hasErrors()){
        return  ResponseEntity.badRequest().body( result.getAllErrors());
    }

    ProductDTOResponse response = createService.createProduct(request);
    //O cadastro estando Ok retorna a mensagem de sucesso (200)
    return  ResponseEntity.ok(response);

}

}