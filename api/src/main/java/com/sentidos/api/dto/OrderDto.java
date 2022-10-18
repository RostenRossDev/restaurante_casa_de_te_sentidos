package com.sentidos.api.dto;

import java.util.Date;
import java.util.List;

import com.sentidos.api.entities.OrderDetail;

public class OrderDto {

	private Date createAt;
	
	private List<OrderDetailDto> orderDetails;

	private Integer state;
	
	private Boolean isDelivered;
	
	private CustomerDto customerDto;

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}	

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Boolean getIsDelivered() {
		return isDelivered;
	}

	public void setIsDelivered(Boolean isDelivered) {
		this.isDelivered = isDelivered;
	}

	public CustomerDto getCustomerDto() {
		return customerDto;
	}

	public void setCustomerDto(CustomerDto customerDto) {
		this.customerDto = customerDto;
	}

	public List<OrderDetailDto> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetailDto> orderDetails) {
		this.orderDetails = orderDetails;
	}

	@Override
	public String toString() {
		return "OrderDto [createAt=" + createAt + ", orderDetails=" + orderDetails + ", state=" + state
				+ ", isDelivered=" + isDelivered + ", customerDto=" + customerDto + "]";
	}
	
	
}
