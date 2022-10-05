package model;

import java.util.Date;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class ReservaTableItem {
	private Button reserva;
	private Long Mesa;
	private String Usuario;
	private String Fecha;
	private Boolean Confirmado;
	private Boolean Te_Comida;
	private Boolean Hora;
	private Button eliminar;
	private Button editar;

	
	
	
	public ReservaTableItem() {
		super();
	}
	public ReservaTableItem(Button reserva, Long mesa, String usuario, String fecha, Boolean confirmado,
			Boolean te_Comida, Boolean hora, Button eliminar, Button editar) {
		super();
		this.reserva = reserva;
		Mesa = mesa;
		Usuario = usuario;
		Fecha = fecha;
		Confirmado = confirmado;
		Te_Comida = te_Comida;
		Hora = hora;
		this.eliminar = eliminar;
		this.editar = editar;
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
	
	public Button getReserva() {
		return reserva;
	}
	public void setReserva(Button reserva) {
		this.reserva = reserva;
	}
	public Button getEliminar() {
		return eliminar;
	}
	public void setEliminar(Button eliminar) {
		this.eliminar = eliminar;
	}
	public Button getEditar() {
		return editar;
	}
	public void setEditar(Button editar) {
		this.editar = editar;
	}
	@Override
	public String toString() {
		return "ReservaTableItem [Mesa=" + Mesa + ", Usuario=" + Usuario + ", Fecha=" + Fecha + ", Confirmado="
				+ Confirmado + ", Te_Comida=" + Te_Comida + ", Hora=" + Hora + "]";
	}	
	
}
