package com.uoons.product.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uoons.product.entity.Product;
import com.uoons.product.repository.ProductRepository;
import com.uoons.product.serviceImpl.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	@Override
	public List<Product> getAllProduct() {
		
		return productRepository.findAll();
	}
	@Override
	public Product getProduct(long productId) {
		return productRepository.getById(productId);
	}
	@Override
	public Product addProduct(Product product) {		
		return productRepository.save(product);
	}

	@Override
	public List<Product> getByProductName(String productName) {
		return productRepository.getByProductName(productName);

	}
	@Override
	public List<Product> getByBrandName(String brandName) {
		return productRepository.getByBrandName(brandName);
	}

	@Override
	public List<Product> getBySellerId(long sellerId) {
		return productRepository.findBySellerId(sellerId);
	}

	@Override
	public List<Product> getBySubCategoryId(long subCategoryId) {
		return productRepository.findBySubCategoryId(subCategoryId);
	}
}
