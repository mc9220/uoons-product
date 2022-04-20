package com.uoons.product.serviceImpl;

import com.uoons.product.entity.Category;
import com.uoons.product.repository.CategoryRepository;
import com.uoons.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category saveCategory(Category category)
    {
        return categoryRepository.save(category);
    }

    @Override
    public Category getCategory(long categoryId) {
        return categoryRepository.getById(categoryId);
    }

    @Override
    public List<Category> getAll(long id) {
        return categoryRepository.getAll(id);
    }
}
