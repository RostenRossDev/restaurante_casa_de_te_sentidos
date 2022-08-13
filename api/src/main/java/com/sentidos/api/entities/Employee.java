package com.sentidos.api.entities;

public class Employee {

	private Long id;
	private String name;
	private String lastName;
	private Integer dni;
	private EmployeeRole employRoll;
	public Employee(Long id, String name, String lastName, Integer dni, EmployeeRole employRoll) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.dni = dni;
		this.employRoll = employRoll;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getDni() {
		return dni;
	}
	public void setDni(Integer dni) {
		this.dni = dni;
	}
	public EmployeeRole getEmployRoll() {
		return employRoll;
	}
	public void setEmployRoll(EmployeeRole employRoll) {
		this.employRoll = employRoll;
	}
	
}
