package com.grizzly.GrizzlyWeb.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grizzly.GrizzlyWeb.entity.Faculty;

@Repository
public interface EmployeeRepository extends JpaRepository<Faculty ,Long>{

}
