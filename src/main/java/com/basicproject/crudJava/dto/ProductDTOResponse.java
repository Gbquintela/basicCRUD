package com.basicproject.crudJava.dto;

import com.basicproject.crudJava.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
// DTO (Data Transfer Object) para a resposta de informações do produto.
public class ProductDTOResponse {
    private String message;
    private String productName;
    private String typeProduct;
    private Double productPrice;
    private Integer quantityOfProduct;
    private String descriptionOfProduct;
    // Metodo estático para converter uma entidade Product em um ProductDTOResponse.
public static ProductDTOResponse fromProduct(Product product){
    ProductDTOResponse dtoResponse = new ProductDTOResponse();
    dtoResponse.setMessage("Produto Cadastrado com sucesso!");
    dtoResponse.setProductName(product.getProductName());
    dtoResponse.setTypeProduct(product.getTypeProduct());
    dtoResponse.setProductPrice(product.getProductPrice());
    dtoResponse.setQuantityOfProduct(product.getQuantityOfProduct());
    dtoResponse.setDescriptionOfProduct(product.getDescriptionOfProduct());

    return dtoResponse;
}

}
