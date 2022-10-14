package com.sentidos.api.dto;

import java.util.ArrayList;
import java.util.List;


public class OrderDesktopDto {

	private Long id;
	private List<OrderDetailDesktopDto> orderDetails;
	private Boolean isDelivered;
	private Integer state;
	
	
	public OrderDesktopDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderDesktopDto(Long id, Boolean isDelivered, Integer state) {
		super();
		this.id = id;
		this.orderDetails = new ArrayList<OrderDetailDesktopDto> ();
		this.isDelivered = isDelivered;
		this.state = state;
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
				+ ", state=" + state + "]";
	}
	
	
}
