package model;

import java.util.Date;
import java.util.List;

public class OrderResponse {

	public Date createAt;
    public List<OrderDetail> orderDetails;
    public int state;
    public boolean isDelivered;
    public Customer customerDto;
	
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
	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}
	public Customer getCustomerDto() {
		return customerDto;
	}
	public void setCustomerDto(Customer customerDto) {
		this.customerDto = customerDto;
	}
	public void setState(int state) {
		this.state = state;
	}
	public void setDelivered(boolean isDelivered) {
		this.isDelivered = isDelivered;
	}
	@Override
	public String toString() {
		return "OrderResponse [createAt=" + createAt + ", orderDetails=" + orderDetails + ", state=" + state
				+ ", isDelivered=" + isDelivered + ", customerDto=" + customerDto + "]";
	}
}

