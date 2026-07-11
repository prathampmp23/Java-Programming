package com.cts.spring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Bike {
	@Id
	String bikeid;
	String make;
	String model;
	
	public String getBikeid() {
		return bikeid;
	}
	public void setBikeid(String bikeid) {
		this.bikeid = bikeid;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Bike(String bikeid, String make, String model) {
		super();
		this.bikeid = bikeid;
		this.make = make;
		this.model = model;
	}
	public Bike() {
		super();
	}
	@Override
	public String toString() {
		return "Bike [bikeid=" + bikeid + ", make=" + make + ", model=" + model + "]";
	}
}
