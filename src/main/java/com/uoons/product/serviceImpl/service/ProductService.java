package com.uoons.product.serviceImpl.service;

import java.util.List;

import com.uoons.product.entity.Product;

public interface ProductService {

	List<Product> getAllProduct();

	Product getProduct(long productId);

	Product addProduct(Product product);

    List<Product> getByProductName(String productName);
    List<Product> getByBrandName(String brandName);

	List<Product> getBySellerId(long sellerId);

	List<Product> getBySubCategoryId(long subCategoryId);
}
