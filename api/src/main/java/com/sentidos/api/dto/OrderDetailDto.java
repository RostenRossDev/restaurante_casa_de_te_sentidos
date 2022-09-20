package com.sentidos.api.dto;

public class OrderDetailDto {	
	
	private Integer quantity;
	
	private MenuDto menuDto;

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public MenuDto getMenuDto() {
		return menuDto;
	}

	public void setMenuDto(MenuDto menuDto) {
		this.menuDto = menuDto;
	}
	
	
}
