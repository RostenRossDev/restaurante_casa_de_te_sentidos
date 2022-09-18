package model;

public class Menu {

	public String name;
    public double price;
    public String menuType;
    public Object isEnabled;
    public Object odrdersDetailDto;
    public Object invoiceDetailDto;

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
	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	
	public String getMenuType() {
		return menuType;
	}
	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}
	public Object getIsEnabled() {
		return isEnabled;
	}
	public void setIsEnabled(Object isEnabled) {
		this.isEnabled = isEnabled;
	}
	public Object getOdrdersDetailDto() {
		return odrdersDetailDto;
	}
	public void setOdrdersDetailDto(Object odrdersDetailDto) {
		this.odrdersDetailDto = odrdersDetailDto;
	}
	public Object getInvoiceDetailDto() {
		return invoiceDetailDto;
	}
	public void setInvoiceDetailDto(Object invoiceDetailDto) {
		this.invoiceDetailDto = invoiceDetailDto;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Menu [name=" + name + ", price=" + price + ", menuType=" + menuType + ", isEnabled=" + isEnabled
				+ ", odrdersDetailDto=" + odrdersDetailDto + ", invoiceDetailDto=" + invoiceDetailDto + "]";
	}
    
}
