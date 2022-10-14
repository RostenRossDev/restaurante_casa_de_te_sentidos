package model;

import java.util.List;


public class Order {
	private Long id;
	private List<OrderDetail> orderDetails;
	private Boolean isDelivered;
	private Integer state;
	private String username;
	private Long tableId;
	
	public Order(Long id, List<OrderDetail> orderDetails, Boolean isDelivered, Integer state) {
		super();
		this.id = id;
		this.orderDetails = orderDetails;
		this.isDelivered = isDelivered;
		this.state = state;
	}
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(List<OrderDetail> orderDetails) {
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
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getTableId() {
		return tableId;
	}

	public void setTableId(Long tableId) {
		this.tableId = tableId;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderDetails=" + orderDetails + ", isDelivered=" + isDelivered + ", state="
				+ state + "]";
	}
	
	
	
}
