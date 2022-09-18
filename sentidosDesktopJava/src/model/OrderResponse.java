package model;

import java.util.Date;
import java.util.List;

public class OrderResponse {

	private Date createAt;
	private Integer state;
    private Boolean isDelivered;
    private List<OrderDetail> orderDetails;
	private List<Customer> customer;
	
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
	public List<Customer> getCustomer() {
		return customer;
	}
	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "OrderResponse [createAt=" + createAt + ", state=" + state + ", isDelivered=" + isDelivered
				+ ", orderDetails=" + orderDetails + ", customer=" + customer + "]";
	}
    
	
}

