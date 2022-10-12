package model;

public class InvoiceDetail {
<<<<<<< HEAD
	
	private Integer quantity;	
=======
    private Integer quantity;	
>>>>>>> 462d7f38d540769c5f2c284744df3f5be1748b90
	
	private Menu menu;

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public InvoiceDetail(Integer quantity, Menu menu) {
		super();
		this.quantity = quantity;
		this.menu = menu;
	}

	public InvoiceDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "InvoiceDetail [quantity=" + quantity + ", menu=" + menu + "]";
	}
<<<<<<< HEAD
	
=======
>>>>>>> 462d7f38d540769c5f2c284744df3f5be1748b90
}
