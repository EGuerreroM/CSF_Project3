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

    private ProductServiceImpl productServiceImpl;
    private CategoryServiceImpl categoryServiceImpl;

    public ProductController(ProductServiceImpl productService, CategoryServiceImpl categoryService) {
        super();
        this.productServiceImpl = productService;
        this.categoryServiceImpl = categoryService;
    }

    @GetMapping("/show")
    public List<Product> showAllProducts(){
        return productServiceImpl.getAllProducts();
    }

    @PostMapping("/save")
    @ResponseBody
    public void saveProduct(){
        Category category = new Category();

        category = categoryServiceImpl.getCategoryById(1L);

        Product product = new Product();
        product.setStock(3);
        product.setName("Camisa Deportiva");
        product.setPrice(300.33);
        product.setImage("URL IMG");
        product.setCategory(category);
        product.setDescription("Camisa Algodon Deportiva");

        productServiceImpl.saveProduct(product);

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
