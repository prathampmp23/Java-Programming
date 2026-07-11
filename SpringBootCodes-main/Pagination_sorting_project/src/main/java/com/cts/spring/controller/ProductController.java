package com.cts.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.spring.dto.APIResponse;
import com.cts.spring.model.Products;
import com.cts.spring.service.ProductsService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	@Autowired
    private ProductsService service;

    @GetMapping
    private APIResponse<List<Products>> getProducts() {
        List<Products> allProducts = service.findAllProducts();
        return new APIResponse<>(allProducts.size(), allProducts);
    }

    @GetMapping("/{field}")
    private APIResponse<List<Products>> getProductsWithSort(@PathVariable String field) {
        List<Products> allProducts = service.findProductsWithSorting(field);
        return new APIResponse<>(allProducts.size(), allProducts);
    }

    @GetMapping("/pagination/{offset}/{pageSize}")
    private APIResponse<Page<Products>> getProductsWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
        Page<Products> productsWithPagination = service.findProductsWithPagination(offset, pageSize);
        return new APIResponse<>(productsWithPagination.getSize(), productsWithPagination);
    }

    @GetMapping("/paginationAndSort/{offset}/{pageSize}/{field}")
    private APIResponse<Page<Products>> getProductsWithPaginationAndSort(@PathVariable int offset, @PathVariable int pageSize, @PathVariable String field) {
        Page<Products> productsWithPagination = service.findProductsWithPaginationAndSorting(offset, pageSize, field);
		return new APIResponse<>(productsWithPagination.getSize(), productsWithPagination);
	}
}
