package model;

public class Menu {

	private String name;
    private Double price;
    private String menuType;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getMenuType() {
		return menuType;
	}
	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}
	
	@Override
	public String toString() {
		return "Menu [name=" + name + ", price=" + price + ", menuType=" + menuType + "]";
	}
    
}
