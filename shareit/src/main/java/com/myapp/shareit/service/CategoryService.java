package com.myapp.shareit.service;

import com.myapp.shareit.domain.Category;
import com.myapp.shareit.exceptions.CategoryNotFoundException;
import com.myapp.shareit.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository=categoryRepository;
    }

    public Optional<Category> getCategory(Long id){
        return categoryRepository.findById(id);

    }

    public List<Category> getAll(){
        return categoryRepository.findAll();
    }

    public void createCategory(Category category){
        categoryRepository.save(category);
    }

    public void updateCategory(Category category){
        categoryRepository.findById(category.getId()).orElseThrow(()->new CategoryNotFoundException("Category notfound"));
        categoryRepository.save(category);
    }

    public void deleteCategory(Long id){
        Category category = categoryRepository.findById(id).orElseThrow(()->new CategoryNotFoundException("Category notfound"));
        categoryRepository.delete(category);
    }


}
