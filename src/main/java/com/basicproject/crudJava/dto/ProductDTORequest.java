package com.basicproject.crudJava.dto;

import com.basicproject.crudJava.entity.Product;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ProductDTORequest {

    @NotBlank(message = "O nome do produto não pode ser vazio!")
    @Size(max = 80, message = "O tamanho maximo e de 80 caracteres")
    private String productName;

    @NotBlank(message = "O tipo do produto não pode ser vazio!")
    @Size(max = 80, message = "O tamanho maximo e de 80 caracteres!")
    private String typeProduct;

    @NotNull
    @Positive(message = "O preço não pode ser negativo!")
    private double productPrice;

    @NotNull
    @PositiveOrZero (message = "A quantidade não pode ser negativa!")
    private int quantityOfProduct;

    @NotBlank(message = "A descrição do produto não pode ser vazia")
    @Size(max = 100, message = "O tamanho maximo e de 100 caracteres")
    private String descriptionOfProduct;



    public Product toEntity (){
        Product product = new Product();

        product.setProductName(productName);
        product.setTypeProduct(typeProduct);
        product.setProductPrice(productPrice);
        product.setQuantityOfProduct(quantityOfProduct);
        product.setDescriptionOfProduct(descriptionOfProduct);

        return product;
    }



}
