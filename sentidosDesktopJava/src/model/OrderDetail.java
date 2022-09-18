package model;

public class OrderDetail {
	 public int quantity;
	 public Menu menuDto;
	
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Menu getMenu() {
		return menuDto;
	}
	public void setMenu(Menu menu) {
		this.menuDto = menu;
	}
	@Override
	public String toString() {
		return "OrderDetail [quantity=" + quantity + ", menu=" + menuDto + "]";
	}	
}
