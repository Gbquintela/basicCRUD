package com.basicproject.crudJava.dto;

import com.basicproject.crudJava.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTOResponse {
    private Long id;
    private String productName;
    private String typeProduct;
    private double productPrice;
    private int quantityOfProduct;
    private String descriptionOfProduct;


}
