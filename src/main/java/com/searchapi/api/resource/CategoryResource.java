package com.searchapi.api.resource;

import com.searchapi.api.model.Category;
import com.searchapi.api.request.body.CategoryBody;
import com.searchapi.api.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/category")
public class CategoryResource {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")
    public List<Category> index(){
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public Category index(int categoryId){
        return categoryService.getCategoryById(categoryId);
    }

    @PostMapping("/")
    public Category store(@Valid @RequestBody CategoryBody categoryBody){
        return categoryService.insertCategory(categoryBody);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@Valid @RequestBody CategoryBody categoryBody, @PathVariable(name = "id") int categoryId){
        return categoryService.updateCategory(categoryId,categoryBody);
    }

    @DeleteMapping("/{id}")
    public Map<String,Boolean> delete(@PathVariable(name="id") int categoryId){
        return categoryService.deleteCategory(categoryId);
    }

}
