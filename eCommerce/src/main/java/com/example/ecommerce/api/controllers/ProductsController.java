package com.example.ecommerce.api.controllers;

import com.example.ecommerce.business.abstracts.ProductService;
import com.example.ecommerce.business.dto.requests.create.CreateProductRequest;
import com.example.ecommerce.business.dto.requests.update.UpdateProductRequest;
import com.example.ecommerce.business.dto.responses.create.CreateProductResponse;
import com.example.ecommerce.business.dto.responses.get.GetAllProductResponse;
import com.example.ecommerce.business.dto.responses.get.GetProductResponse;
import com.example.ecommerce.business.dto.responses.update.UpdateProductResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/product")
public class ProductsController {

    private final ProductService service;

    @GetMapping
    public List<GetAllProductResponse> getAll(){
        return service.getAll();
    }
    @GetMapping("/{id}")
    public GetProductResponse getById(@PathVariable int id){
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateProductResponse add(@RequestBody CreateProductRequest request){
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdateProductResponse update(@PathVariable int id, @RequestBody UpdateProductRequest request){
        return service.update(id,request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id){
        service.delete(id);
    }
}
