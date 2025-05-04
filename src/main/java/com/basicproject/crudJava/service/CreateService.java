package com.basicproject.crudJava.service;

import com.basicproject.crudJava.dto.ProductDTORequest;
import com.basicproject.crudJava.dto.ProductDTOResponse;
import com.basicproject.crudJava.entity.Product;
import com.basicproject.crudJava.repository.ProductRepository;
import org.springframework.stereotype.Service;

//Anotaçaão para representar que uma classe de serviço
@Service
public class CreateService {

    // Repositório de produtos para operações de banco de dados
    private final ProductRepository productRepository;

    /**
     * Construtor com injeção de dependência do repositório
     * @param productRepository Instância do repositório de produtos
     */
    public CreateService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public ProductDTOResponse createProduct(ProductDTORequest request) {
        // Converte o DTO de requisição para entidade Product
        Product product = request.toProduct();

        // Salva o produto no banco de dados
        Product productCreated = productRepository.save(product);

        // Converte a entidade salva para DTO de resposta
        return ProductDTOResponse.fromProduct(productCreated);
    }
}
