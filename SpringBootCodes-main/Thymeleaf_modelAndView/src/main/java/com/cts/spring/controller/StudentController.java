package com.cts.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cts.spring.model.Student;

@Controller
public class StudentController {

	@GetMapping("/validate")
	public String validate(@RequestParam("lid") String username, @RequestParam("pwd") String password) {
		if (username.equals("admin") && password.equals("12345"))
			return "true";
		else
			return "false";
	}

	@GetMapping("/show")
	public String show(Model model) { // Model - holds only data
		List<Student> students = new ArrayList<>();
		students.add(new Student(1, "Pratham", "CSE"));
		students.add(new Student(2, "Bino", "EEE"));
		students.add(new Student(3, "Suresh", "ECE"));
		students.add(new Student(4, "Suhas", "CSE"));
		students.add(new Student(5, "Manoj", "Civil"));
		model.addAttribute("data", students);
		return "show";
	}

	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("name", "Pratham");
		model.addAttribute("city", "Nagpur");
		return "home";
	}

	@GetMapping("/login")
	public ModelAndView getHome() { // ModelAndView - hold data as well as view name
		return new ModelAndView("login");
	}
}