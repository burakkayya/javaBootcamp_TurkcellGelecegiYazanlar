package com.example.ecommerce.api.controllers;

import com.example.ecommerce.business.abstracts.ProductService;
import com.example.ecommerce.entities.concretes.Product;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/products")
public class ProductsController {

    private final ProductService service;

    @GetMapping
    public List<Product> getAll(){
        return service.getAll();
    }
    @GetMapping("/{id}")
    public Product getById(@PathVariable int id){
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product add(@RequestBody Product product){
        return service.add(product);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable int id, @RequestBody Product product){
        return service.update(id,product);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id){
        service.delete(id);
    }
}
