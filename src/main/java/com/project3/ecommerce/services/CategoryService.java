package com.project3.ecommerce.services;

import com.project3.ecommerce.models.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    Category saveCategory(Category category);
    Category getCategoryById(Long id);
    Category updateCategory(Category category);
    void deleteCategoryById(Long id);
}
