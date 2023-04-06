package com.example.ecommerce.repository.abstracts;

import com.example.ecommerce.entities.concretes.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
