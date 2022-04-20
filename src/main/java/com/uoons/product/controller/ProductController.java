package com.uoons.product.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.uoons.product.dto.ProductDto;
import com.uoons.product.entity.ProductImage;
import com.uoons.product.service.ProductImageService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.uoons.product.entity.Product;
import com.uoons.product.service.ProductService;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductImageService imageService;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private ProductService productService;

	@GetMapping("/get")
	public List<ProductDto> getAllProducts() {
//        return productService.getAllProduct();
		return productService.getAllProduct().stream().map(product -> modelMapper.map(product, ProductDto.class))
				.collect(Collectors.toList());
	}

	@GetMapping("/get/{productId}")
	public ProductDto getProduct(@PathVariable long productId) {
//        return productService.getProduct(productId);
		Product product = productService.getProduct(productId);

		// convert entity to DTO
		ProductDto productResponse = modelMapper.map(product, ProductDto.class);

		return productResponse;
	}
	@GetMapping("/getByName/{productName}")
	public List<ProductDto> getProductByName(@PathVariable String productName) {
//        return productService.getProduct(productId);
		return productService.getByProductName(productName).stream().map(product -> modelMapper.map(product, ProductDto.class))
				.collect(Collectors.toList());    }

	@PostMapping("/add")
	public Product addProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}

	@PostMapping(value = "/save")
	public ProductDto saveImage(@RequestPart("data") ProductDto productDto, @RequestPart("images") MultipartFile[] files, @RequestPart("thumb") MultipartFile thumb) {
//        List<String> fileNames = new ArrayList<>();
//        Arrays.asList(files).stream().forEach(file -> {
//            fileNames.add(file.getOriginalFilename());
//        });
		List<URL> imageUrl = imageService.saveImage(files);
		URL thumbUrl = imageService.savethumb(thumb);
		List<ProductImage> productImageList = new ArrayList<>();
		int count = 0;
		for (URL e : imageUrl
		) {
			ProductImage productImage = new ProductImage();
			productImage.setProductImageUrl(e);
			count++;
			productImage.setImageType("ProductImage" + count);
			productImageList.add(productImage);
		}
		ProductImage productImage = new ProductImage();
		productImage.setProductImageUrl(thumbUrl);
		productImage.setImageType("thumbnail");
		productImageList.add(productImage);

		Product productrequest = modelMapper.map(productDto, Product.class);
		productrequest.setProductImages(productImageList);
		Product product = productService.addProduct(productrequest);

		// convert entity to DTO
		ProductDto productResponse = modelMapper.map(product, ProductDto.class);

		System.out.println(productDto);
//        System.out.println(fileNames);
		System.out.println(imageUrl);
		return productResponse;
	}
}
