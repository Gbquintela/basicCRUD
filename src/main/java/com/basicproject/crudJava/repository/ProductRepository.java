package com.basicproject.crudJava.repository;

import com.basicproject.crudJava.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Interface que estende JpaRepository, fornecendo métodos para operações CRUD (Create, Read, Update, Delete) na entidade Product.
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
