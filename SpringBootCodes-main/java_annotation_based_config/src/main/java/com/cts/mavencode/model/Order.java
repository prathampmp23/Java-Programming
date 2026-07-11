package com.cts.mavencode.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Order {

	int oid;

	// 1. Field Level or Field Injection
	 @Autowired
	Product product;

	public Order() {
		oid = 1;

	}

	// 2. Constructor Injection
	public Order(int oid, Product product) {
		super();
		this.oid = oid;
		this.product = product;
	}
 
	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public Product getProduct() {
		return product;
	}

	// 3. setter injection
//	@Autowired 
//	public void setProduct(Product product) {
//		this.product = product;
//	}

	@Override
	public String toString() {
		return "Order [oid=" + oid + ", product=" + product + "]";
	}
}
