package com.cts.spring.service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cts.spring.doa.ProductsDao;
import com.cts.spring.model.Products;

import jakarta.annotation.PostConstruct;

@Service
public class ProductServiceImpl implements ProductsService {

	@Autowired
	ProductsDao dao;

	@PostConstruct
	public void initDB() {
		List<Products> products = IntStream.rangeClosed(1, 200)
				.mapToObj(i -> new Products("product" + i, new Random().nextInt(100), new Random().nextInt(50000)))
				.collect(Collectors.toList());
		dao.saveAll(products);
	}

	public List<Products> findAllProducts() {
		return dao.findAll();
	}

	public List<Products> findProductsWithSorting(String field) {
		return dao.findAll(Sort.by(Sort.Direction.ASC, field));
	}

	public Page<Products> findProductsWithPagination(int offset, int pageSize) {
		Page<Products> products = dao.findAll(PageRequest.of(offset, pageSize));
		return products;
	}

	public Page<Products> findProductsWithPaginationAndSorting(int offset, int pageSize, String field) {
		Page<Products> products = dao.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
		return products;
	}

}
