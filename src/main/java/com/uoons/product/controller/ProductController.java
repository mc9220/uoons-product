package com.uoons.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uoons.product.entity.Product;
import com.uoons.product.serviceImpl.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	@GetMapping("/get")
	public List<Product> getAllProducts(){
		return productService.getAllProduct();
	}
	
	@GetMapping("/get/{productId}")
	public Product getProduct(@PathVariable long productId) {
		return productService.getProduct(productId);
	}
	
	@PostMapping("/add")
	public Product addProduct(@RequestBody Product product) {
		return productService.addProduct(product);
		}

	@GetMapping("/getbyproductname/{productName}")
	public List<Product> getByName(@PathVariable String productName){
		return productService.getByProductName(productName);
	}
	@GetMapping("/getbybrandname/{brandName}")
	public List<Product> getByBrandName(@PathVariable String brandName){
		return productService.getByBrandName(brandName);
	}

	@GetMapping("/getbysellerid/{sellerId}")
	public List<Product> getBySellerId(@PathVariable long sellerId){
		return productService.getBySellerId(sellerId);
	}
	@GetMapping("/getbysubcategoryid/{subCategoryId}")
	public List<Product> getBySubCategoryId(@PathVariable long subCategoryId){
		return productService.getBySubCategoryId(subCategoryId);
	}
}
