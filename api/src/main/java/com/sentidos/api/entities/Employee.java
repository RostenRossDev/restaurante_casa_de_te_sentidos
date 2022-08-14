package com.sentidos.api.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="employees")
public class Employee  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String lastname;
	private Integer dni;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name="employees_roles", joinColumns = @JoinColumn(name="employee_id"), 
	inverseJoinColumns = @JoinColumn(name="employee_role_id"))
	private List<EmployeeRole> employRolls;

	
	public Employee(Long id, String name, String lastname, Integer dni, List<EmployeeRole> employRolls) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.dni = dni;
		this.employRolls = employRolls;
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
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Integer getDni() {
		return dni;
	}
	public void setDni(Integer dni) {
		this.dni = dni;
	}
	public List<EmployeeRole> getEmployRoll() {
		return employRolls;
	}
	public void setEmployRoll(List<EmployeeRole> employRoll) {
		this.employRolls = employRoll;
	}
	
}
