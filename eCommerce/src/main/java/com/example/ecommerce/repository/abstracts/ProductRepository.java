package com.example.ecommerce.repository.abstracts;

import com.example.ecommerce.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
