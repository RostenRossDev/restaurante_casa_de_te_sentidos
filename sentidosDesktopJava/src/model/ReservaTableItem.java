package model;

import java.util.Date;

import Servicios.HttpReservaService;
import home.Main;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ReservaTableItem {
	private Long id;
	private Button reserva;
	private Long Mesa;
	private String Usuario;
	private String Fecha;
	private Boolean Confirmado;
	private Boolean Te_Comida;
	private Boolean Hora;
	private Button eliminar;
	private Button editar;

	
	public ReservaTableItem(Long id,Long mesa, String usuario, String fecha, Boolean confirmado,
			Boolean te_Comida, Boolean hora) {
		super();
		this.id=id;
		this.reserva = getNewReservaButton();
		reserva.addEventFilter(MouseEvent.MOUSE_CLICKED, evcentClickReserva);
		Mesa = mesa;
		Usuario = usuario;
		Fecha = fecha;
		Confirmado = confirmado;
		Te_Comida = te_Comida;
		Hora = hora;
		this.eliminar = getNewEliminarButton();
		this.editar = getNewEeditarButton();
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
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "ReservaTableItem [Mesa=" + Mesa + ", Usuario=" + Usuario + ", Fecha=" + Fecha + ", Confirmado="
				+ Confirmado + ", Te_Comida=" + Te_Comida + ", Hora=" + Hora + "]";
	}

	private Button getNewEliminarButton() {
		Button btn = new Button();
		Image imgRemove = new Image("/images/remove.png");
		ImageView eliminar = new ImageView();
		eliminar.setImage(imgRemove);
		btn.setGraphic(eliminar);
		btn.setScaleX(0.5);
		btn.setScaleY(0.5);
		btn.setStyle("-fx-padding:-5px;-fx-border-insets: -5px;-fx-background-insets: -5px; -fx-background-color: transparent;");  
		btn.addEventFilter(MouseEvent.MOUSE_CLICKED, evcentClickReserva);
		btn.setCursor(Cursor.HAND);
		return btn;
	}
	private Button getNewEeditarButton() {
		Button btn = new Button();
		Image imgEdit = new Image("/images/edit.png");
		ImageView editar = new ImageView();
		editar.setImage(imgEdit);
		btn.setGraphic(editar);
		btn.setScaleX(0.5);
		btn.setScaleY(0.5);
		btn.addEventFilter(MouseEvent.MOUSE_CLICKED, evcentClickReserva);
		btn.setStyle("-fx-padding:-5px;-fx-border-insets: -5px;-fx-background-insets: -5px; -fx-background-color: transparent;");  
		btn.setCursor(Cursor.HAND);
		return btn;
	}
	private Button getNewReservaButton() { /// sentidosDesktopJava/src/images/reservation.png
		Button btn = new Button();
		Image imgReserva = new Image("/images/icons8_Search_52px.png");
		ImageView reserva = new ImageView();
		reserva.setImage(imgReserva);
		btn.setGraphic(reserva);
		btn.setScaleX(0.5);
		btn.setScaleY(0.5);
		btn.addEventFilter(MouseEvent.MOUSE_CLICKED, evcentClickReserva);
		btn.setStyle("-fx-padding:-5px;-fx-border-insets: -5px;-fx-background-insets: -5px; -fx-background-color: transparent;");  
		btn.setCursor(Cursor.HAND);
		return btn;
	}


	EventHandler<MouseEvent> evcentClickReserva = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {
			System.out.println("clickeo en reserva: " +this);

		}
	};

	EventHandler<MouseEvent> evcentClickEliminar = new EventHandler<MouseEvent>() {
		
		@Override
		public void handle(MouseEvent event) {
			System.out.println("clickeo en eliminar");
			HttpReservaService reservaService = new HttpReservaService();
			reservaService.borrarReserva("{id:"+id+"}");
		}
	};

	EventHandler<MouseEvent> evcentClickEditar = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {
			System.out.println("clickeo en editar");
		}
	};
}
