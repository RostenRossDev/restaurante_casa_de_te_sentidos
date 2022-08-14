package com.sentidos.api.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="menus")
public class Menu implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private Double price;
	
	private Boolean isEnabled;
	
	@ManyToOne()
    @JoinColumn(name = "menuType_id")
	private MenuType menuType;
    
	
	public Menu(Long id, String name, Double price, Boolean isEnabled) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.isEnabled = isEnabled;
	}
	
	public Menu() {
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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Boolean getIsEnabled() {
		return isEnabled;
	}
	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public MenuType getMenuType() {
		return menuType;
	}

	public void setMenuType(MenuType menuType) {
		this.menuType = menuType;
	}
	
	
}
