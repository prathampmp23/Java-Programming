package com.cts.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.spring.dao.BikeDao;
import com.cts.spring.model.Bike;

@Service
public class BikeServiceImp implements BikeService {
	
	@Autowired
	BikeDao dao;

	@Override
	public List<Bike> getAllBikes() {
		return dao.findAll();
	}

	@Override
	public boolean addBike(Bike bike) {
		dao.save(bike);
		return true;
	}

	@Override
	public List<Bike> searchBikes(String make) {
		return dao.findAllByMake(make);
	}

	@Override
	public boolean deleteBike(String bikeid) {
		dao.deleteById(bikeid);
		return true;
	}

}
