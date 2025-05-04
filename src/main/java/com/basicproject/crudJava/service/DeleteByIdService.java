package com.basicproject.crudJava.service;


import com.basicproject.crudJava.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteByIdService {

    private final ProductRepository productRepository;


    public DeleteByIdService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    /**
     * Metodo para deletar um produto pelo ID
     * @param id ID do produto a ser deletado
     * @return true se o produto foi deletado, false se o produto não foi encontrado
     */
    public boolean deleteProductById(Long id) {
        // Verifica se o produto existe antes de tentar deletar
        if (productRepository.existsById(id)) {
            // Se existir, deleta o produto
            productRepository.deleteById(id);
            return true; // Retorna sucesso
        }
        // Se não existir, retorna false
        return false;
    }
}
