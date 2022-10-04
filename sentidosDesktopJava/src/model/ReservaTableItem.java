package model;

import java.util.Date;

public class ReservaTableItem {
	private Long Mesa;
	private String Usuario;
	private String Fecha;
	private Boolean Confirmado;
	private Boolean Te_Comida;
	private Boolean Hora;
	
	
	
	public ReservaTableItem() {
		super();
	}
	public ReservaTableItem(Long mesa, String usuario, String fecha, Boolean confirmado, Boolean te_Comida,
			Boolean hora) {
		super();
		Mesa = mesa;
		Usuario = usuario;
		Fecha = fecha;
		Confirmado = confirmado;
		Te_Comida = te_Comida;
		Hora = hora;
	}
	public Long getMesa() {
		return Mesa;
	}
	public void setMesa(Long mesa) {
		Mesa = mesa;
	}
	public String getUsuario() {
		return Usuario;
	}
	public void setUsuario(String usuario) {
		Usuario = usuario;
	}
	public String getFecha() {
		return Fecha;
	}
	public void setFecha(String fecha) {
		Fecha = fecha;
	}
	public Boolean getConfirmado() {
		return Confirmado;
	}
	public void setConfirmado(Boolean confirmado) {
		Confirmado = confirmado;
	}
	public Boolean getTe_Comida() {
		return Te_Comida;
	}
	public void setTe_Comida(Boolean te_Comida) {
		Te_Comida = te_Comida;
	}
	public Boolean getHora() {
		return Hora;
	}
	public void setHora(Boolean hora) {
		Hora = hora;
	}
	@Override
	public String toString() {
		return "ReservaTableItem [Mesa=" + Mesa + ", Usuario=" + Usuario + ", Fecha=" + Fecha + ", Confirmado="
				+ Confirmado + ", Te_Comida=" + Te_Comida + ", Hora=" + Hora + "]";
	}	
	
}
