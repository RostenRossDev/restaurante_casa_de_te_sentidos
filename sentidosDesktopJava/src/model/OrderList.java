package model;

import java.util.List;

public class OrderList {

	private List<OrderResponse> orders;

	public List<OrderResponse> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderResponse> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "OrderList [orders=" + orders + "]";
	}	
	
}
