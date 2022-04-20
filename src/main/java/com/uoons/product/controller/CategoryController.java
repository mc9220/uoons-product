package com.uoons.product.controller;

import com.uoons.product.entity.Category;
import com.uoons.product.serviceImpl.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/newcategory")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    @PostMapping("/add")
    public Category saveNewCategory(@RequestBody Category category){
        System.out.println("Category name "+ category.getCategoryName());
        return  categoryService.saveCategory(category);
    }

    @GetMapping("/get/{categoryId}")
    public Category getCategory(@PathVariable long categoryId){
        return  categoryService.getCategory(categoryId);
    }
    @GetMapping("/getby/{id}")
    public List<Category> getAll(@PathVariable long id){
        return categoryService.getAll(id);
    }
}
