package com.grizzly.GrizzlyWeb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grizzly.GrizzlyWeb.repo.DepartmentRepository;
import com.grizzly.GrizzlyWeb.repo.EmployeeRepository;

@Controller
@RequestMapping("/Test")
public class GrizzlyService {
	
	private EmployeeRepository employeeRepo;
	private DepartmentRepository departmentRepo;
	
	@Autowired
	public GrizzlyService(EmployeeRepository employeeRepo, DepartmentRepository departmentRepo) {
		
		this.departmentRepo = departmentRepo;
		this.employeeRepo = employeeRepo;
	}
	
	@GetMapping("/hi")
	public String getText() {
		return "This is me!";
	}

}
