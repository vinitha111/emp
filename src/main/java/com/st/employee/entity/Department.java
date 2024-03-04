package com.st.employee.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Department {
	@Id
	@GeneratedValue
    private int  id;
	private String name; 
	
	public Department() {
		super();
		
	}
	public Department(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}
}
