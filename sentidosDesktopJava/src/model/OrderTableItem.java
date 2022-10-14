package model;

import java.util.Date;

import Servicios.HttpReservaService;
import home.Controller;
import home.Main;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

public class OrderTableItem {

	private Long id;
	private Boolean esDeilivery;
	private Integer estado;
	private String usuario;
	private Long mesa;
	private Date fechaEntrega;
	private Double total;
	private Button orden;
	private Button eliminar;
	private Button editar;
	private Pane panelEditar;
	
	
	
	
	public OrderTableItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderTableItem(Long id, Boolean esDeilivery, Integer estado, String usuario, Long mesa, Date fechaEntrega,
			Double total) {
		super();
		this.id = id;
		this.esDeilivery = esDeilivery;
		this.estado = estado;
		this.usuario = usuario;
		this.mesa = mesa;
		this.fechaEntrega = fechaEntrega;
		this.total = total;
		this.eliminar= getNewEliminarButton();
		this.editar= getNewEeditarButton();
		this.orden = getNewOrdenButton();
		System.out.println("total: "+total);

	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Boolean getEsDeilivery() {
		return esDeilivery;
	}
	public void setEsDeilivery(Boolean esDeilivery) {
		this.esDeilivery = esDeilivery;
	}
	public Integer getEstado() {
		return estado;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public Long getMesa() {
		return mesa;
	}
	public void setMesa(Long mesa) {
		this.mesa = mesa;
	}
	public Button getOrden() {
		return orden;
	}
	public void setOrden(Button orden) {
		this.orden = orden;
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
	public Pane getPanelEditar() {
		return panelEditar;
	}
	public void setPanelEditar(Pane panelEditar) {
		this.panelEditar = panelEditar;
	}
	
	public Date getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
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

	private Button getNewOrdenButton() { /// sentidosDesktopJava/src/images/reservation.png
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
			System.out.println("clickeo en orden: " + this);

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
				pushNot.setTitle("Orden");
				pushNot.setMessage("Orden eliminada con exito!");
				pushNot.setAnimationType(AnimationType.POPUP);
				pushNot.showAndDismiss(Duration.seconds(2)); 

				pushNot.showAndWait();
				((Controller) Main.contexto.get("controller")).actualizarTablaReservas();
			} else {
				NotificationType notification = NotificationType.ERROR;
				TrayNotification pushNot = new TrayNotification();
				pushNot.setNotificationType(notification);
				pushNot.setTitle("Reserva");
				pushNot.setMessage("Ha ocurrido un problema!! Vuelva a intentar.");
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
			System.out.println("clickeo en editar orden");
		}
	};
	
}
