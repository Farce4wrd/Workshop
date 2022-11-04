package com.grizzly.GrizzlyWeb.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="FACULTY")
public class Faculty {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="FACULTY_ID")
	private long id;
	
	@Column(name="FACULTY_FNAME")
	private String firstName;
	
	@Column(name="FACULTY_LNAME")
	private String lastName;
	
	@Column(name="FACULTY_PHONE")
	private long phone;
	
	@Column(name="FACULTY_EMAIL")
	private String email;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="DEPARTMENTID")
	private Department department;
	
	public Faculty() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone
				+ ", email=" + email + ", department=" + department + "]";
	}
	
	
}
