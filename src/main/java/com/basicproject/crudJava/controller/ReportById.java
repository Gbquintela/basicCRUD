package com.basicproject.crudJava.controller;

import com.basicproject.crudJava.entity.Product;
import com.basicproject.crudJava.service.ReportByIdService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

// Controlador REST para a operação de buscar um produto por ID.
@RestController
// Define o caminho base para as requisições deste controlador como "/products".
@RequestMapping("/products")
public class ReportById {

    private final ReportByIdService reportByIdService;

    // Injeção de dependência do serviço responsável por buscar um produto por ID.
    public ReportById( ReportByIdService reportByIdService) {
        this.reportByIdService = reportByIdService;
    }

    // Endpoint para buscar um produto específico através de uma requisição HTTP GET em "/products/reportById/{id}", onde {id} é o ID do produto a ser buscado.
    @GetMapping("/reportById/{id}")
    public ResponseEntity<?> reportById(@PathVariable long id){
        // Chama o serviço para obter um Optional contendo o produto com o ID fornecido.
        Optional<Product> product = reportByIdService.getProductById(id);

        // Verifica se o Optional contém um produto.
        if(product.isPresent()){
            // Se o produto estiver presente, retorna uma resposta HTTP 200 (OK) com o produto no corpo da resposta.
            return  ResponseEntity.ok(product.get());
        } else {
            // Se o produto não for encontrado (Optional vazio), retorna uma resposta HTTP 404 (NOT_FOUND).
            return ResponseEntity.notFound().build();
        }
    }
}