package com.basicproject.crudJava.dto;

import com.basicproject.crudJava.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter

public class ProductDTOResponse {
    private String message;
    private String productName;
    private String typeProduct;
    private Double productPrice;
    private Integer quantityOfProduct;
    private String descriptionOfProduct;


public static ProductDTOResponse fromEntity(Product product){
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
