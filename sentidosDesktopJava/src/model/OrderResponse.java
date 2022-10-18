package model;

import java.util.Date;
import java.util.List;

public class OrderResponse {
	
	private Long id;
	private Date fechaEntrega;
	private List<OrderDetail> orderDetails;
	private int state;
	private boolean isDelivered;
	private String username;
	private Long tableId;	
	private Double total;
	public OrderResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public OrderResponse(Long id, Date fechaEntrega, List<OrderDetail> orderDetails, int state, boolean isDelivered,
			String username, Long tableId) {
		super();
		calculateTotal();
		this.id = id;
		this.fechaEntrega = fechaEntrega;
		this.orderDetails = orderDetails;
		this.state = state;
		this.isDelivered = isDelivered;
		this.username = username;
		this.tableId = tableId;		
		
	}
	
	public void calculateTotal() {
		Double tot =0.0;
		for (OrderDetail o : orderDetails) {
			System.out.println("usuario: "+username+"pre total: "+o.getPrice()+", cantidad: "+o.getQuantity());
			tot += o.getPrice() * o.getQuantity();
		}
		System.out.println("total calculado: "+tot);
		this.total=tot;
	}
	public Date getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String customerDto) {
		this.username = customerDto;
	}
	public void setState(int state) {
		this.state = state;
	}
	public void setDelivered(boolean isDelivered) {
		this.isDelivered = isDelivered;
	}	
	
	public Long getTableId() {
		return tableId;
	}
	public void setTableId(Long tableId) {
		this.tableId = tableId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}	
	
	public Double getTotal() {
		System.out.println("total: "+total);
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "OrderResponse [id=" + id + ", createAt=" + fechaEntrega + ", orderDetails=" + orderDetails + ", state="
				+ state + ", isDelivered=" + isDelivered + ", username=" + username + ", tableId=" + tableId + "]";
	}
	
	
}

