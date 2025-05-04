package com.basicproject.crudJava.dto;

import com.basicproject.crudJava.entity.Product;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

// DTO (Data Transfer Object) para receber dados de requisição para criar/atualizar um produto.
@Getter
@Setter
public class ProductDTORequest {

    // Validação para garantir que o nome do produto não esteja em branco e tenha no máximo 80 caracteres.
    @NotBlank(message = "O nome do produto não pode ser vazio!")
    @Size(max = 80, message = "O tamanho maximo e de 80 caracteres")
    private String productName;

    // Validação para garantir que o tipo do produto não esteja em branco e tenha no máximo 80 caracteres.
    @NotBlank(message = "O tipo do produto não pode ser vazio!")
    @Size(max = 80, message = "O tamanho maximo e de 80 caracteres!")
    private String typeProduct;

    // Validação para garantir que o preço do produto não seja nulo e seja um valor positivo.
    @NotNull
    @Positive(message = "O preço não pode ser negativo!")
    private Double productPrice;

    // Validação para garantir que a quantidade do produto não seja nula e seja um valor positivo ou zero.
    @NotNull
    @PositiveOrZero (message = "A quantidade não pode ser negativa!")
    private Integer quantityOfProduct;

    // Validação para garantir que a descrição do produto não esteja em branco e tenha no máximo 100 caracteres.
    @NotBlank(message = "A descrição do produto não pode ser vazia")
    @Size(max = 100, message = "O tamanho maximo e de 100 caracteres")
    private String descriptionOfProduct;

    // Metodo para converter este DTO em uma entidade Product.

    public Product toProduct (){
        Product product = new Product();

        product.setProductName(productName);
        product.setTypeProduct(typeProduct);
        product.setProductPrice(productPrice);
        product.setQuantityOfProduct(quantityOfProduct);
        product.setDescriptionOfProduct(descriptionOfProduct);

        return product;
    }



}
