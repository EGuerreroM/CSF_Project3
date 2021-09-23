package com.project3.ecommerce.controllers;

import com.project3.ecommerce.models.Category;
import com.project3.ecommerce.services.implementations.CategoryServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private CategoryServiceImpl categoryServiceImpl;

    public CategoryController(CategoryServiceImpl categoryServiceImpl) {
        super();
        this.categoryServiceImpl = categoryServiceImpl;
    }

    @GetMapping("/show")
    public List<Category> showCategories(){
        return categoryServiceImpl.getAllCategories();
    }

//    @GetMapping("/show")
//    public String showCategories(Model model){
//        model.addAttribute("categories",categoryServiceImpl.getAllCategories());
//        return "views/showCategories.html";
//    }

    @PostMapping("/save")
    @ResponseBody
    public Category saveCategory(@ModelAttribute Category category){
        return categoryServiceImpl.saveCategory(category);
    }
}
