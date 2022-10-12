package model;

import java.util.Date;

import Servicios.HttpReservaService;
import home.Controller;
import home.Main;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import tray.*;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

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
	private Pane panelEditar; 
	
	
	public ReservaTableItem(Long id, Long mesa, String usuario, String fecha, Boolean confirmado, Boolean te_Comida,
			Boolean hora) {
		super();
		this.id = id;
		this.reserva = getNewReservaButton();
		reserva.addEventFilter(MouseEvent.MOUSE_CLICKED, eventClickReserva);
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
	
	public Pane getPanelEditar() {
		return panelEditar;
	}

	public void setPanelEditar(Pane panelEditar) {
		this.panelEditar = panelEditar;
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
		btn.setStyle(
				"-fx-padding:-5px;-fx-border-insets: -5px;-fx-background-insets: -5px; -fx-background-color: transparent;");
		btn.addEventFilter(MouseEvent.MOUSE_CLICKED, eventClickEliminar);
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
		btn.addEventFilter(MouseEvent.MOUSE_CLICKED, eventClickEditar);
		btn.setStyle(
				"-fx-padding:-5px;-fx-border-insets: -5px;-fx-background-insets: -5px; -fx-background-color: transparent;");
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
		btn.addEventFilter(MouseEvent.MOUSE_CLICKED, eventClickReserva);
		btn.setStyle(
				"-fx-padding:-5px;-fx-border-insets: -5px;-fx-background-insets: -5px; -fx-background-color: transparent;");
		btn.setCursor(Cursor.HAND);
		return btn;
	}

	EventHandler<MouseEvent> eventClickReserva = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {
			System.out.println("clickeo en reserva: " + this);

		}
	};

	EventHandler<MouseEvent> eventClickEliminar = new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent event) {
			System.out.println("clickeo en eliminar");
			HttpReservaService reservaService = new HttpReservaService();
			if (reservaService.borrarReserva("{\"id\":" + id + "}")) {
				NotificationType notification = NotificationType.SUCCESS;

				TrayNotification pushNot = new TrayNotification();
				pushNot.setNotificationType(notification);
				pushNot.setTitle("Reserva");
				pushNot.setMessage("Reserva eliminada con exito!");
				pushNot.setAnimationType(AnimationType.POPUP);
				pushNot.showAndDismiss(Duration.seconds(2)); 
				pushNot.showAndWait(); 
				((Controller) Main.contexto.get("controller")).actualizarTablaReservas();				
			} else {
				NotificationType notification = NotificationType.ERROR;

				TrayNotification pushNot = new TrayNotification();
				pushNot.setNotificationType(notification);
				pushNot.setTitle("Reserva");
				pushNot.setMessage("Ah ocurrido un problema!! Vuelva a intentar.");
				pushNot.setAnimationType(AnimationType.POPUP);
				pushNot.showAndDismiss(Duration.seconds(2));
				pushNot.showAndWait();
			}
		}
	};
	
	EventHandler<MouseEvent> eventClickEditar = new EventHandler<MouseEvent>() {
		
		@Override
		public void handle(MouseEvent event) {
			panelEditar.setVisible(true);
			panelEditar.toFront();	
			System.out.println("clickeo en editar reserva");
		}
	};
}
