package model;

public class Menu {
<<<<<<< HEAD
	private String name;
	
	private Double price;
	
	private String menuType;
=======

	private String name;
    private Double price;
    private String menuType;
>>>>>>> 462d7f38d540769c5f2c284744df3f5be1748b90

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
<<<<<<< HEAD

=======
>>>>>>> 462d7f38d540769c5f2c284744df3f5be1748b90
	public String getMenuType() {
		return menuType;
	}

	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}
<<<<<<< HEAD

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

=======
	
>>>>>>> 462d7f38d540769c5f2c284744df3f5be1748b90
	@Override
	public String toString() {
		return "Menu [name=" + name + ", price=" + price + ", menuType=" + menuType + "]";
	}
    
}
