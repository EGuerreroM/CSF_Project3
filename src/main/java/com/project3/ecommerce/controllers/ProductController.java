package com.project3.ecommerce.controllers;


import com.project3.ecommerce.models.Category;
import com.project3.ecommerce.models.Product;
import com.project3.ecommerce.services.implementations.CategoryServiceImpl;
import com.project3.ecommerce.services.implementations.ProductServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductServiceImpl productService;
    private CategoryServiceImpl categoryService;

    public ProductController(ProductServiceImpl productService, CategoryServiceImpl categoryService) {
        super();
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping("/show")
    public List<Product> showAllProducts(){
        return productService.getAllProducts();
    }
    @GetMapping("/save")
    public void saveProduct(){
        Category category = new Category();

        category = categoryService.getCategoryById(1L);

        Product product = new Product();
        product.setStock(5);
        product.setName("Camisa Polo");
        product.setPrice(950.20);
        product.setImage("URL IMG");
        product.setCategory(category);
        product.setDescription("Camisa Algodon de Suiza");

        productService.saveProduct(product);

    }

//    @PutMapping("/update")
//    public Product updateProduct(
//            @PathVariable(value="id") Long productId,
//            @ModelAttribute Product product){
//        Product foundedProduct = productService.getProductById(productId);
//        foundedProduct.setName(product.getName());
//        foundedProduct.setStock(product.getStock());
//        foundedProduct.setPrice(product.getPrice());
//        foundedProduct.setImage(product.getImage());
//
//        return productService.saveProduct(foundedProduct)
//    }

}
