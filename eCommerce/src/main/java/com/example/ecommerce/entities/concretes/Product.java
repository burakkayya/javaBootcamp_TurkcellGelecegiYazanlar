package com.example.ecommerce.entities.concretes;

import com.example.ecommerce.entities.enums.Status;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private  int quantity;
    private double unitPrice;
    private String description;
    @JsonManagedReference
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Category> categories=new HashSet<>();
    @Enumerated(EnumType.STRING)
    private Status status;
}
