package com.grizzly.GrizzlyWeb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grizzly.GrizzlyWeb.entity.Faculty;
import com.grizzly.GrizzlyWeb.repo.DepartmentRepository;
import com.grizzly.GrizzlyWeb.repo.EmployeeRepository;

@RestController
@RequestMapping("/Grizzlies")
public class GrizzlyWebService {
	
	private EmployeeRepository employeeRepo;
	private DepartmentRepository departmentRepo;
	
	@Autowired
	public GrizzlyWebService(EmployeeRepository employeeRepo, DepartmentRepository departmentRepo) {
		this.employeeRepo = employeeRepo;
		this.departmentRepo = departmentRepo;
	}

	//CRUD 
	
	@GetMapping("/employee/{id}")
	public Faculty getEmployee(@PathVariable long id) {
		return this.employeeRepo.findById(id).get();
		
	}
	
	
	
	@GetMapping("/employee/all")
	public Iterable<Faculty> getEmployees(){
		return this.employeeRepo.findAll();
	}
	
	@GetMapping()
	public String getSth() {
		return "Hi World, help";
	}
}
