package com.basicproject.crudJava.repository;

import com.basicproject.crudJava.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
