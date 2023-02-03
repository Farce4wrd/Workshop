package com.grizzly.GrizzlyWeb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grizzly.GrizzlyWeb.entity.Department;
import com.grizzly.GrizzlyWeb.entity.Faculty;
import com.grizzly.GrizzlyWeb.repo.DepartmentRepository;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	private DepartmentRepository departmentRepo;

	@Autowired 
	public DepartmentController(DepartmentRepository departmentRepo) {
		this.departmentRepo = departmentRepo;
	}
	
	@GetMapping
	public List<Department> getAllDepartment(){
		return this.departmentRepo.findAll();
	}
	
	@GetMapping("/{id}/faculties")
	public List<Faculty> getAllFaculty(@PathVariable long id){
		Department dept = this.departmentRepo.findById(id).get();
		return dept.getFaculties();
	}
	
	@GetMapping("/{id}")
	public Department getDept(@PathVariable long id) {
		return this.departmentRepo.findById(id).get();
		
	}
	
	@PostMapping()
	public void addDepartment(@RequestBody Department department) {
		this.departmentRepo.save(department);
	}
	
	@PutMapping("/{id}")
	public void updateDepartment(@RequestBody Department updDept, @PathVariable long id) {
		Department dept = this.departmentRepo.findById(id).get();
		dept.setName(updDept.getName());
		dept.setLocation(updDept.getLocation());
		dept.setPhone(updDept.getPhone());
		dept.setFaculty(updDept.getFaculties());
		this.departmentRepo.save(dept);
	}
	
}
