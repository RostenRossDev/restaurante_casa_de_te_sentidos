package model;

import java.util.Date;
import java.util.List;

public class Ticket {
    private Long id;
	private String usuario;
	private Boolean pagado;
	private List<InvoiceDetail> invoicesDetail;
	private String metodoPago;
	private Date fechaPago;
    private Date createAt;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public Boolean getPagado() {
		return pagado;
	}
	public void setPagado(Boolean pagado) {
		this.pagado = pagado;
	}
	public List<InvoiceDetail> getInvoicesDetails() {
		return invoicesDetail;
	}
	public void setInvoicesDetails(List<InvoiceDetail> invoicesDto) {
		this.invoicesDetail = invoicesDto;
	}
	public String getMetodoPago() {
		return metodoPago;
	}
	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}
	public Date getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public Double getTotal() {
		Double total = 0.0;
		
		for (InvoiceDetail invoiceDetail : invoicesDetail) {
			total = total + invoiceDetail.getQuantity()*invoiceDetail.getMenu().getPrice();
		}		
		
		return total;
	}
	public Ticket(Long id, String usuario, Boolean pagado, List<InvoiceDetail> invoicesDto, String metodoPago,
			Date fechaPago, Date createAt) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.pagado = pagado;
		this.invoicesDetail = invoicesDto;
		this.metodoPago = metodoPago;
		this.fechaPago = fechaPago;
		this.createAt = createAt;
	}
	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Ticket [id=" + id + ", usuario=" + usuario + ", pagado=" + pagado + ", invoicesDetail=" + invoicesDetail
				+ ", metodoPago=" + metodoPago + ", fechaPago=" + fechaPago + ", createAt=" + createAt + "]";
	}   

}
