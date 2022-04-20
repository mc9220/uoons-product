package com.uoons.product.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.uoons.product.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name ="product_detail")
public class Product extends BaseEntity implements Serializable{
	
	private static final long serialVersionUID = 8302371663316855182L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private long productId;
	
	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "brand_name")
	private String brand;
	
	private double weight;
	
	private double length;
	
	private double height;
	
	private double width;
	
	private double price;
	
	@Column(name = "offer_price")
	private double offerPrice;
	
	private String color;
	
	private String varient;
	
	private String salientFeatures;
	@NotNull
	@Column(name = "seller_id")
	private long sellerId;
	
	@Column(name = "is_available")
	private boolean isAvailable;
	
	@Column(name = "total_quantity")
	@Min(message = "Value should Not less then 1", value = 0)
	private int totalQuantity;
	
	private String description;
	
	private int gst;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="product_id")
	private List<ProductImage> productImages;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category Category;


}
