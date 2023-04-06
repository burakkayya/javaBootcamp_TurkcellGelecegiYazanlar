package com.example.ecommerce.business.concretes;

import com.example.ecommerce.business.abstracts.CategoryService;
import com.example.ecommerce.business.dto.requests.create.CreateCategoryRequest;
import com.example.ecommerce.business.dto.requests.update.UpdateCategoryRequest;
import com.example.ecommerce.business.dto.responses.create.CreateCategoryResponse;
import com.example.ecommerce.business.dto.responses.get.GetAllCategoryResponse;
import com.example.ecommerce.business.dto.responses.get.GetCategoryResponse;
import com.example.ecommerce.business.dto.responses.update.UpdateCategoryResponse;
import com.example.ecommerce.entities.concretes.Category;
import com.example.ecommerce.repository.abstracts.CategoryRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class CategoryManager implements CategoryService {

    private final CategoryRepository repository;
    private final ModelMapper mapper;
    @Override
    public List<GetAllCategoryResponse> getAll() {
        List<Category> categories = repository.findAll();
        List<GetAllCategoryResponse> responses = categories
                .stream()
                .map(category -> mapper.map(category,GetAllCategoryResponse.class))
                .toList();
        return responses;
    }

    @Override
    public GetCategoryResponse getById(int id) {
        checkIfCategoryExists(id);
        Category category = repository.findById(id).orElseThrow();
        GetCategoryResponse response = mapper.map(category,GetCategoryResponse.class);
        return response;
    }

    @Override
    public CreateCategoryResponse add(CreateCategoryRequest request) {
        Category category = mapper.map(request, Category.class);
        category.setId(0);
        Category createdCategory = repository.save(category);
        CreateCategoryResponse response = mapper.map(createdCategory, CreateCategoryResponse.class);
        return response;
    }

    @Override
    public UpdateCategoryResponse update(int id, UpdateCategoryRequest request) {
        checkIfCategoryExists(id);
        Category category = mapper.map(request, Category.class);
        category.setId(id);
        Category updatedCategory = repository.save(category);
        UpdateCategoryResponse response = mapper.map(updatedCategory,UpdateCategoryResponse.class);
        return response;
    }

    @Override
    public void delete(int id) {
        checkIfCategoryExists(id);
        repository.deleteById(id);
    }

    private void checkIfCategoryExists(int id){
        if(!repository.existsById(id)) throw new RuntimeException("Böyle bir ürün mevcut değil!");
    }

}
