package com.uoons.product.support;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategorySupport {
	private long categoryId;
	private String categoryName;

}
