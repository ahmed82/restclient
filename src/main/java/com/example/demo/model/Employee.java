package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Employee {
	
	private String id;
	
	
	private String name;
	private String description;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescriptioin() {
		return description;
	}

	public void setDescriptioin(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"id='" + id + '\'' +
				", name='" + name+'\'' +
				", description='" + description + '\'' +
                '}';
	}
	
	

}
