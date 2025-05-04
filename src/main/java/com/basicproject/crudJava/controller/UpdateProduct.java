package com.basicproject.crudJava.controller;

import com.basicproject.crudJava.entity.Product;
import com.basicproject.crudJava.service.UpdateService;
import org.springframework.web.bind.annotation.*;

// Controlador REST para a operação de atualizar um produto existente.
@RestController
// Define o caminho base para as requisições deste controlador como "/products".
@RequestMapping("/products")
public class UpdateProduct {

    private final UpdateService updateProducts;

    // Injeção de dependência do serviço responsável pela lógica de atualização de produtos.
    public UpdateProduct(UpdateService updateProducts) {
        this.updateProducts = updateProducts;
    }

    // Endpoint para atualizar um produto específico através de uma requisição HTTP POST em "/products/update/{id}", onde {id} é o ID do produto a ser atualizado e os dados do produto atualizado são passados no corpo da requisição.
    @PutMapping("/update/{id}")
    public String updateProduct(@PathVariable Long id, @ModelAttribute Product product){
        try{
            // Chama o serviço para atualizar o produto com o ID e os dados fornecidos.
            updateProducts.updateProduct(id, product);
            // Se a atualização for bem-sucedida, retorna uma mensagem de sucesso.
            return "Produto atualizado com sucesso!";
        } catch (Exception e) {
            // Em caso de alguma exceção durante a atualização, lança uma RuntimeException.
            throw new RuntimeException(e);
        }
    }
}