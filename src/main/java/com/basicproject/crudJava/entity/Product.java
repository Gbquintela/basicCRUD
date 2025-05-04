package com.basicproject.crudJava.entity;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.Getter;
import lombok.Setter;

// Anotação que marca esta classe como uma entidade JPA (será mapeada para uma tabela no banco)
@Entity
// Especifica o nome da tabela no banco de dados (opcional - se não usar, usará o nome da classe)
@Table(name = "products")
@Getter // Gera automaticamente os getters (Lombok)
@Setter // Gera automaticamente os setters (Lombok)
public class Product {

    // Marca este campo como a chave primária da tabela
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    // Mapeia para uma coluna no banco com restrições:
    // nullable = false → não aceita valores nulos
    // length = 80 → tamanho máximo de 80 caracteres
    @Column(nullable = false, length = 80)
    private String productName;  // Nome do produto

    @Column(nullable = false, length = 80)
    private String typeProduct;  // Tipo/categoria do produto

    // Coluna para preço (não pode ser nula)
    // Double para valores decimais
    @Column(nullable = false)
    private Double productPrice;  // Preço do produto

    // Coluna para quantidade (não pode ser nula)
    // Integer para números inteiros
    @Column(nullable = false)
    private Integer quantityOfProduct;  // Quantidade em estoque

    // Coluna para descrição com tamanho máximo de 100 caracteres
    @Column(nullable = false, length = 100)
    private String descriptionOfProduct;  // Descrição detalhada





}
