package com.uoons.product.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.boot.jaxb.mapping.internal.FetchTypeMarshalling;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "new_category_details")
public class Category implements Serializable {
    private static final long serialVersionUID = 830237166331685518L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private long categoryId;
    @Column(name = "category_name")
    private String categoryName;


    @JsonManagedReference
    @ManyToOne(fetch= FetchType.EAGER)
    private Category parentCategory;


    @JsonBackReference
    @OneToMany(mappedBy = "parentCategory")
    private Set<Category> subCategories;

/*
    @OneToMany(fetch = FetchType.LAZY)
    private List<Product> products;
*/

}
