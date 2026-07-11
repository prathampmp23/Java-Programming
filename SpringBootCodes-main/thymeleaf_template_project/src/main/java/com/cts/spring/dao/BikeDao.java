package com.cts.spring.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.spring.model.Bike;

public interface BikeDao extends JpaRepository<Bike, String> {
	public List<Bike> findAllByMake(String make);
}
