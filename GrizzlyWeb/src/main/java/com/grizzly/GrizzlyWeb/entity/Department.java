package com.grizzly.GrizzlyWeb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="DEPARTMENT")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="DEPARTMENT_ID")
	private long id;
	
	@Column(name="DEPARTMENT_NAME")
	private String name;
	
	@Column(name="DEPARTMENT_PHONE")
	private int phone;
	
	@Column(name="DEPARTMENT_LOCATION")
	private String location;
	
	@OneToMany(mappedBy="department", cascade=CascadeType.ALL)
	private List<Faculty> faculties = new ArrayList<Faculty>();

	public Department() {
		
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
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
				+ ", employees=" + faculties + "]";
	}
}
