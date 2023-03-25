package com.example.ecommerce.business.concretes;

import com.example.ecommerce.business.abstracts.ProductService;
import com.example.ecommerce.entities.concretes.Product;
import com.example.ecommerce.repository.abstracts.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class ProductManager implements ProductService {

    private final ProductRepository repository;

    @Override
    public List<Product> getAll() {
        return repository.findAll();
    }

    @Override
    public Product getById(int id) {
        checkIfBrandExists(id);
        return repository.findById(id).orElseThrow();
    }

    @Override
    public Product add(Product product) {
        validateProduct(product);
        return repository.save(product);
    }

    @Override
    public Product update(int id, Product product) {
        checkIfBrandExists(id);
        validateProduct(product);
        product.setId(id);
        return repository.save(product);
    }

    @Override
    public void delete(int id) {
        checkIfBrandExists(id);
        repository.deleteById(id);
    }


    private void checkIfBrandExists(int id){
        if(!repository.existsById(id)) throw new RuntimeException("Böyle bir ürün mevcut değil!");
    }
    private void validateProduct(Product product){
        checkIfDescriptionLengthValid(product);
        checkIfQuantityValid(product);
        checkIfUnitPriceValid(product);
    }

    private void checkIfDescriptionLengthValid(Product product) {
        if(product.getDescription().length()<10 || product.getDescription().length()>50) throw new IllegalArgumentException("Description lenght must be between 10 and 50 character.");
    }

    private void checkIfQuantityValid(Product product) {
        if(product.getQuantity()<0) throw new IllegalArgumentException("Quantity can not be less than zero.");
    }

    private void checkIfUnitPriceValid(Product product) {
        if(product.getUnitPrice()<=0) throw new IllegalArgumentException("Price cannot be less than or equal zero.");
    }
}
