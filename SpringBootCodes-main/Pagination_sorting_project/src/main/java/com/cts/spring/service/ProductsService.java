package com.cts.spring.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.cts.spring.model.Products;

public interface ProductsService {
	public List<Products> findAllProducts();
	public List<Products> findProductsWithSorting(String field);
	public Page<Products> findProductsWithPagination(int offset, int pageSize);
	public Page<Products> findProductsWithPaginationAndSorting(int offset, int pageSize, String field);
}
