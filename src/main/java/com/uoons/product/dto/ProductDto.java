package com.uoons.product.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.uoons.product.entity.ProductImage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
	private String productName;
	private String brand;
	private double weight;
	private double length;
	private double height;
	private double width;
	private double price;
	private double offerPrice;
	private String color;
	private String varient;
	private String salientFeatures;
	private long sellerId;
	private boolean isAvailable;
	private int totalQuantity;
	private String description;
	private int gst;

	//    private MultipartFile[] files;
	private List<ProductImage> productImages;

}
