package com.example.ecommerce.repository.concretes;

import com.example.ecommerce.entities.concretes.Product;
import com.example.ecommerce.repository.abstracts.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryProductRepository implements ProductRepository {

    List<Product> products;

    public InMemoryProductRepository() {
        products = new ArrayList<>();
        products.add(new Product(1,"Iphone 14",10,30000.99,"apple's product"));
        products.add(new Product(2,"Macbook Air",8,27000.99,"apple's product"));
        products.add(new Product(3,"XBox",13,25000,"microsoft's product"));
        products.add(new Product(4,"Ps5",15,17000,"sony's product"));
        products.add(new Product(5,"Dyson v15",20,9300.99,"dyson's product"));

    }

    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public Product getById(int id) {
        return products.get(id-1);
    }

    @Override
    public Product add(Product product) {
        products.add(product);
        return product;
    }

    @Override
    public Product update(int id, Product product) {

        return products.set(id-1,product);
    }

    @Override
    public void delete(int id) {
        products.remove(id-1);
    }
}
