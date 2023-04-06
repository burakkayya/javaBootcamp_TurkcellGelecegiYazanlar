package com.example.ecommerce.business.abstracts;

import com.example.ecommerce.business.dto.requests.create.CreateProductRequest;
import com.example.ecommerce.business.dto.requests.update.UpdateProductRequest;
import com.example.ecommerce.business.dto.responses.create.CreateProductResponse;
import com.example.ecommerce.business.dto.responses.get.GetAllProductResponse;
import com.example.ecommerce.business.dto.responses.get.GetProductResponse;
import com.example.ecommerce.business.dto.responses.update.UpdateProductResponse;

import java.util.List;

public interface ProductService {
    List<GetAllProductResponse> getAll();
    GetProductResponse getById(int id);
    CreateProductResponse add(CreateProductRequest request);
    UpdateProductResponse update(int id, UpdateProductRequest request);
    void delete(int id);

}
