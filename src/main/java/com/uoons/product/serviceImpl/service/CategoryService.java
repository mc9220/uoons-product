package com.uoons.product.serviceImpl.service;

import com.uoons.product.entity.Category;

import java.util.List;

public interface CategoryService {
    Category saveCategory(Category category);
    Category getCategory(long categoryId);

    List<Category> getAll(long id);
}
