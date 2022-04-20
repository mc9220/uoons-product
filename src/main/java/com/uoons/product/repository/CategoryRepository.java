package com.uoons.product.repository;

import com.uoons.product.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query(value = "select * from new_category_details where parent_category_category_id = :id ",nativeQuery = true)
    List<Category> getAll(@Param("id") long id);
}
