package com.myapp.shareit.controller;

import com.myapp.shareit.domain.Category;
import com.myapp.shareit.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }
    @GetMapping
    public List<Category> getAll(){
        return categoryService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Category> getById(@PathVariable Long id){
        return categoryService.getCategory(id);
    }
    @PostMapping
    public void createCategory(@Valid @RequestBody Category category){
        categoryService.createCategory(category);
    }
    @PutMapping
    public void updateCategory(@RequestBody Category category){
        categoryService.updateCategory(category);
    }
    @DeleteMapping
    public void deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
    }
}
