package com.basicproject.crudJava.entity;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, length = 80)
    private String productName;

    @Column(nullable = false, length = 80)
    private String typeProduct;

    @Column(nullable = false)
    private double productPrice;

    @Column(nullable = false)
    private int quantityOfProduct;

    @Column(nullable = false, length = 100)
    private String descriptionOfProduct;






}
