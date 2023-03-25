package com.example.ecommerce.repository.abstracts;

import com.example.ecommerce.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {


}
