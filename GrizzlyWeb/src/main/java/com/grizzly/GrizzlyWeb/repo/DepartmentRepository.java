package com.grizzly.GrizzlyWeb.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grizzly.GrizzlyWeb.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
	
}
