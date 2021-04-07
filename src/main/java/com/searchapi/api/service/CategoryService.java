package com.searchapi.api.service;

import com.searchapi.api.model.Category;
import com.searchapi.api.repository.CategoryRepository;
import com.searchapi.api.request.body.CategoryBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public Category getCategoryById(int categoryId){
        return categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category with specified Id not found!"));
    }

    public Category insertCategory(CategoryBody categoryBody){

        Category category = new Category();

        category.setCategory(categoryBody.getName());


        return categoryRepository.save(category);
    }

    public ResponseEntity<Category> updateCategory(int categoryId, CategoryBody categoryDetails){

        Category category = categoryRepository
                .findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category with specified Id not found!"));

        category.setCategory(categoryDetails.getName());

        Category updatedCategory = categoryRepository.save(category);

        return ResponseEntity.ok(updatedCategory);
    }

    public Map<String,Boolean> deleteCategory(int categoryId){

        Category category = categoryRepository
                .findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Cateogory not found on Id!"));

        categoryRepository.delete(category);

        Map<String,Boolean> response = new HashMap<>();

        response.put("deleted",Boolean.FALSE);
        return response;

    }

}
