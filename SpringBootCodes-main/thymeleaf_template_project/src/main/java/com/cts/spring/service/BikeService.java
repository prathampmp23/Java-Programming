package com.cts.spring.service;

import java.util.List;

import com.cts.spring.model.Bike;

public interface BikeService {
	public List<Bike> getAllBikes();// findAll()
	public boolean addBike(Bike bike); //save()
	public List<Bike> searchBikes(String make); 
	public boolean deleteBike(String bikeid); // deleteByBikeid
}
