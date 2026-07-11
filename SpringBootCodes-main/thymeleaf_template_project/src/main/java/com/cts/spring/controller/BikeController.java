package com.cts.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cts.spring.model.Bike;
import com.cts.spring.service.BikeService;

@Controller
public class BikeController {
	@Autowired
	BikeService service;

	@GetMapping("/")
	public String menu() {
		return "menu";
	}

	@PostMapping("/addbike")
	public String addBike(@RequestParam("bikeid") String bikeid, @RequestParam("make") String make,
			@RequestParam("model") String model) {
		service.addBike(new Bike(bikeid, make, model));
		return "menu";
	}

	@GetMapping("/addPage")
	public String addPage() {
		return "add";
	}

	@GetMapping("/display")
	public String display(Model model) {
		model.addAttribute("bikes", service.getAllBikes());
		return "display";
	}

	@GetMapping("/searchPage")
	public String searchPage() {
		return "search";
	}

	@PostMapping("/searchbike")
	public String searchbike(@RequestParam("make") String make, Model model) {
		model.addAttribute("bikes", service.searchBikes(make));
		return "display";
	}

}
