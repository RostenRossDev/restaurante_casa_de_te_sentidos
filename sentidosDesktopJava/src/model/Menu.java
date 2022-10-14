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

	public Menu(String name, Double price, String menuType) {
		super();
		this.name = name;
		this.price = price;
		this.menuType = menuType;
	}

	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Menu [name=" + name + ", price=" + price + ", menuType=" + menuType + "]";
	}
    
}
