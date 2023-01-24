package com.grizzly.GrizzlyWeb.controller;

import java.util.ArrayList;

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
import com.grizzly.GrizzlyWeb.exception.NotFoundException;
import com.grizzly.GrizzlyWeb.repo.DepartmentRepository;
import com.grizzly.GrizzlyWeb.repo.FacultyRepository;

@RestController
@RequestMapping("/grizzlies")
public class GrizzlyWebService {
	
	private FacultyRepository facultyRepo;
	private DepartmentRepository departmentRepo;
	
	@Autowired
	public GrizzlyWebService(FacultyRepository facultyRepo, DepartmentRepository departmentRepo) {
		this.facultyRepo = facultyRepo;
		this.departmentRepo = departmentRepo;
	}

	
	
	@GetMapping("/faculty/{id}")
	public Faculty getFaculty(@PathVariable long id) {
		return this.facultyRepo.findById(id).get();
		
	}
	
	@GetMapping("/department/{id}")
	public Department getDept(@PathVariable long id) {
		return this.departmentRepo.findById(id).get();
		
	}
	@GetMapping("/department/")
	public Iterable<Department> getDept(){
		return this.departmentRepo.findAll();
	}
	
	
	@GetMapping("/faculty/")
	public Iterable<Faculty> getFaculty(){
		return this.facultyRepo.findAll();
	}
	
	@PostMapping("/faculty")
	public void addFaculty(@RequestBody Faculty faculty) {
		this.facultyRepo.save(faculty);
	}
	
	@PutMapping("/faculty/{id}")
	public void updateFaculty(@RequestBody Faculty faculty, @PathVariable long id) {
		Faculty updateFaculty = this.facultyRepo.findById(id).orElseThrow(() -> new NotFoundException("Can't find existing faculty on that id"));
		updateFaculty.setEmail(faculty.getEmail());
		updateFaculty.setFirstName(faculty.getFirstName());
		updateFaculty.setLastName(faculty.getLastName());
		updateFaculty.setPhone(faculty.getPhone());
		this.facultyRepo.save(updateFaculty);
	}
}
