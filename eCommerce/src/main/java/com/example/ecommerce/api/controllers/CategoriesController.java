package com.example.ecommerce.api.controllers;

import com.example.ecommerce.business.abstracts.CategoryService;
import com.example.ecommerce.business.dto.requests.create.CreateCategoryRequest;
import com.example.ecommerce.business.dto.requests.update.UpdateCategoryRequest;
import com.example.ecommerce.business.dto.responses.create.CreateCategoryResponse;
import com.example.ecommerce.business.dto.responses.get.GetAllCategoryResponse;
import com.example.ecommerce.business.dto.responses.get.GetCategoryResponse;
import com.example.ecommerce.business.dto.responses.update.UpdateCategoryResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/category")
public class CategoriesController {

    private final CategoryService service;

    @GetMapping
    public List<GetAllCategoryResponse> getAll(){
        return service.getAll();
    }
    @GetMapping("/{id}")
    public GetCategoryResponse getById(@PathVariable int id){
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateCategoryResponse add(@RequestBody CreateCategoryRequest request){
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdateCategoryResponse update(@PathVariable int id, @RequestBody UpdateCategoryRequest request){
        return service.update(id,request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id){
        service.delete(id);
    }
}
