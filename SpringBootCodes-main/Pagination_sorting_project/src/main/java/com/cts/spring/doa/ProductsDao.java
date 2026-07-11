package com.cts.spring.doa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.spring.model.Products;

public interface ProductsDao extends JpaRepository<Products, Integer> {

}
