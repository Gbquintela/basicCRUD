package com.basicproject.crudJava.controller;

import com.basicproject.crudJava.entity.Product;
import com.basicproject.crudJava.service.UpdateService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class UpdateProduct {

    private final UpdateService updateProducts;


    public UpdateProduct(UpdateService updateProducts) {
        this.updateProducts = updateProducts;
    }

    @PostMapping("/update/{id}")
    public String updateProduct(@PathVariable Long id, @ModelAttribute Product product){
        try{
            updateProducts.updateProduct(id, product);
                return "Produto atualizado com sucesso!";
        } catch (Exception e) {

             throw new RuntimeException(e);

        }


    }
}
