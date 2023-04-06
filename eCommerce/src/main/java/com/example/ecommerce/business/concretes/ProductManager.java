package com.example.ecommerce.business.concretes;

import com.example.ecommerce.business.abstracts.ProductService;
import com.example.ecommerce.business.dto.requests.create.CreateProductRequest;
import com.example.ecommerce.business.dto.requests.update.UpdateProductRequest;
import com.example.ecommerce.business.dto.responses.create.CreateProductResponse;
import com.example.ecommerce.business.dto.responses.get.GetAllProductResponse;
import com.example.ecommerce.business.dto.responses.get.GetProductResponse;
import com.example.ecommerce.business.dto.responses.update.UpdateProductResponse;
import com.example.ecommerce.entities.concretes.Product;
import com.example.ecommerce.repository.abstracts.ProductRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class ProductManager implements ProductService {

    private final ProductRepository repository;
    private final ModelMapper mapper;

    @Override
    public List<GetAllProductResponse> getAll() {
        List<Product> products = repository.findAll();
        List<GetAllProductResponse> responses = products
                .stream()
                .map(product -> mapper.map(product,GetAllProductResponse.class))
                .toList();
        return responses;
    }

    @Override
    public GetProductResponse getById(int id) {
        checkIfProductExists(id);
        Product product = repository.findById(id).orElseThrow();
        GetProductResponse response = mapper.map(product,GetProductResponse.class);
        return response;
    }

    @Override
    public CreateProductResponse add(CreateProductRequest request) {

        Product product = mapper.map(request, Product.class);
        product.setId(0);
        validateProduct(product);
        Product createdProduct = repository.save(product);
        CreateProductResponse response = mapper.map(createdProduct, CreateProductResponse.class);
        return response;
    }

    @Override
    public UpdateProductResponse update(int id, UpdateProductRequest request) {
        checkIfProductExists(id);
        Product product = mapper.map(request, Product.class);
        product.setId(id);
        validateProduct(product);
        Product updatedProduct = repository.save(product);
        UpdateProductResponse response = mapper.map(updatedProduct,UpdateProductResponse.class);
        return response;
    }

    @Override
    public void delete(int id) {
        checkIfProductExists(id);
        repository.deleteById(id);
    }


    private void checkIfProductExists(int id){
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
