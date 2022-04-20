package com.uoons.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.uoons.product.entity.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

   @Query(value = "select * from product_detail where product_name like %:productName% ", nativeQuery = true)
    List<Product> getByProductName(@Param("productName") String productName);

    @Query(value = "select * from product_detail where brand_name like %:brandName% ", nativeQuery = true)
    List<Product> getByBrandName(@Param("brandName")String brandName);

    List<Product> findBySellerId(long sellerId);

    @Query(value = "select * from product_detail where sub_category_id = :subCategoryId ", nativeQuery = true)
    List<Product> findBySubCategoryId(@Param("subCategoryId") long subCategoryId);
}
