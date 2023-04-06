package com.example.ecommerce.business.abstracts;

import com.example.ecommerce.business.dto.requests.create.CreateCategoryRequest;
import com.example.ecommerce.business.dto.requests.update.UpdateCategoryRequest;
import com.example.ecommerce.business.dto.responses.create.CreateCategoryResponse;
import com.example.ecommerce.business.dto.responses.get.GetAllCategoryResponse;
import com.example.ecommerce.business.dto.responses.get.GetCategoryResponse;
import com.example.ecommerce.business.dto.responses.update.UpdateCategoryResponse;

import java.util.List;

public interface CategoryService {
    List<GetAllCategoryResponse> getAll();
    GetCategoryResponse getById(int id);
    CreateCategoryResponse add(CreateCategoryRequest request);
    UpdateCategoryResponse update(int id, UpdateCategoryRequest request);
    void  delete(int id);
}
