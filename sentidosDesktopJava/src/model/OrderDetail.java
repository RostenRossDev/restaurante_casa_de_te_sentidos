package model;

public class OrderDetail {
	private int quantity;
	private String name;
	private String menuType;
	private Double price;

	
	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDetail(int quantity, String name, String menuType, Double price) {
		super();
		this.quantity = quantity;
		this.name = name;
		this.menuType = menuType;
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMenuType() {
		return menuType;
	}

	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "OrderDetail [quantity=" + quantity + ", name=" + name + ", menuType=" + menuType + ", price=" + price
				+ "]";
	}
	
}
