package com.sentidos.api.dto;

import java.util.ArrayList;
import java.util.List;


public class OrderDesktopDto {

	private Long id;
	private List<OrderDetailDesktopDto> orderDetails;
	private Boolean isDelivered;
	private Integer state;
	private String username;
	
	public OrderDesktopDto() {
		super();
		this.orderDetails = new ArrayList<OrderDetailDesktopDto> ();

		// TODO Auto-generated constructor stub
	}
	
	public OrderDesktopDto(Long id, List<OrderDetailDesktopDto> orderDetails, Boolean isDelivered, Integer state,
			String username) {
		super();
		this.id = id;
		this.orderDetails = orderDetails;
		this.isDelivered = isDelivered;
		this.state = state;
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<OrderDetailDesktopDto> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(List<OrderDetailDesktopDto> orderDetails) {
		this.orderDetails = orderDetails;
	}
	public Boolean getIsDelivered() {
		return isDelivered;
	}
	public void setIsDelivered(Boolean isDelivered) {
		this.isDelivered = isDelivered;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "OrderDesktopDto [id=" + id + ", orderDetails=" + orderDetails + ", isDelivered=" + isDelivered
				+ ", state=" + state + ", username=" + username + "]";
	}	
		
}
