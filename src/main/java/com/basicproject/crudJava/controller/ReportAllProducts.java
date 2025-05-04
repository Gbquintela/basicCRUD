package com.basicproject.crudJava.controller;

import com.basicproject.crudJava.entity.Product;
import com.basicproject.crudJava.service.ReportAllService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Controlador REST para a operação de listar todos os produtos.
@RestController
// Define o caminho base para as requisições deste controlador como "/products".
@RequestMapping("/products")
public class ReportAllProducts {

    private final ReportAllService reportAllService;

    // Injeção de dependência do serviço responsável por buscar todos os produtos.
    public ReportAllProducts( ReportAllService reportAllService) {
        this.reportAllService = reportAllService;
    }

    // Endpoint para buscar e retornar todos os produtos através de uma requisição HTTP GET em "/products/reportAll".
    @GetMapping("/reportAll")
    public ResponseEntity<?> reportAllProducts() {
        try {
            // Chama o serviço para obter a lista de todos os produtos.
            List<Product> products = reportAllService.getAllProducts();

            // Verifica se a lista de produtos está vazia.
            if (products.isEmpty()) {
                // Se não houver produtos, retorna uma resposta HTTP 404 (NOT_FOUND) com uma mensagem indicando que nenhum produto foi encontrado.
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum produto encontrado");
            }
            // Se houver produtos, retorna uma resposta HTTP 200 (OK) com a lista de produtos no corpo da resposta.
            return ResponseEntity.ok(products);
        } catch (Exception e){
            // Em caso de alguma exceção durante a busca, retorna uma resposta HTTP 500 (INTERNAL_SERVER_ERROR) com uma mensagem de erro e os detalhes da exceção.
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error ao buscar produtos " + e.getMessage());
        }
    }
}