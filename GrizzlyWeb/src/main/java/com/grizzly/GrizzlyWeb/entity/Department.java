package com.grizzly.GrizzlyWeb.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@jakarta.persistence.Entity
@Table(name="DEPARTMENT")
public class Department  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="DEPARTMENT_ID")
	private long id;
	
	@Column(name="DEPARTMENT_NAME")
	private String name;
	
	@Column(name="DEPARTMENT_PHONE")
	private long phone;
	
	@Column(name="DEPARTMENT_LOCATION")
	private String location;
	
	@OneToMany(mappedBy="department", cascade=CascadeType.ALL)
	private List<Faculty> faculties = new ArrayList<Faculty>();

	public Department() {
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", phone=" + phone + ", location=" + location
				+ ", faculties=" + faculties + "]";
	}
	public List<Faculty> getFaculties() {
		return this.faculties;
	}
	public void addFaculty(Faculty faculty) {
		this.faculties.add(faculty);
	}
	public void setFaculty(List<Faculty> facul) {
		this.faculties = facul;
	}
	public void removeFaculty(Faculty faculty) {
		this.faculties.remove(faculty);
	}
}
