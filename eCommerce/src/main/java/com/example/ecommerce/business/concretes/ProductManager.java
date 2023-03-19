package com.example.ecommerce.business.concretes;

import com.example.ecommerce.business.abstracts.ProductService;
import com.example.ecommerce.entities.concretes.Product;
import com.example.ecommerce.repository.abstracts.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductManager implements ProductService {

    private final ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> getAll() {
        return repository.getAll();
    }

    @Override
    public Product getById(int id) {
        return repository.getById(id);
    }

    @Override
    public Product add(Product product) {
        validateProduct(product);
        return repository.add(product);
    }

    @Override
    public Product update(int id, Product product) {
        validateProduct(product);
        return repository.update(id,product);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
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
