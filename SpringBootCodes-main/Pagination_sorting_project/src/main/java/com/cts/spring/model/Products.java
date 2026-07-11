package com.cts.spring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Products {
	@Id
    @GeneratedValue
    private  int id;
    private String name;
    private int quantity;
    private long price;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public Products(int id, String name, int quantity, long price) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}
	public Products() {
		super();
	}
	public Products(String name, int quantity, long price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
	@Override
	public String toString() {
		return "Products [id=" + id + ", name=" + name + ", quantity=" + quantity + ", price=" + price + "]";
	}
}
