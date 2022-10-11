package model;

import java.util.Date;

import javax.swing.text.html.HTMLEditorKit.LinkController;

import Servicios.HttpReservaService;
import Servicios.HttpTicketService;
import home.Controller;
import home.Main;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

public class TicketTableItem {
    private Button ticket;
	private Long id;
	private Date fechaCreacion;
	private String usuario;
	private Double total;
	private Boolean pagado;
	private String metodoPago;
	private Date fechaPago;
	private Button eliminar;
	private Button editar;
	private Pane panelEditar; 

	
	public Button getTicket() {
		return ticket;
	}
	public void setTicket(Button ticket) {
		this.ticket = ticket;
	}
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
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Boolean getPagado() {
		return pagado;
	}
	public void setPagado(Boolean pagado) {
		this.pagado = pagado;
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
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public TicketTableItem(Long id, Date fechaCreacion, String usuario, Double total, Boolean pagado,
			String metodoPago, Date fechaPago) {
		super();
		this.id = id;
		this.fechaCreacion = fechaCreacion;
		this.usuario = usuario;
		this.total = total;
		this.pagado = pagado;
		this.metodoPago = metodoPago;
		this.fechaPago = fechaPago;
		this.eliminar= getNewEliminarButton();
		this.editar= getNewEeditarButton();
		this.ticket = getNewTicketButton();
	}
	public TicketTableItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "TicketTableItem [id=" + id + ", fechaCreacion=" + fechaCreacion + ", usuario="
				+ usuario + ", total=" + total + ", pagado=" + pagado + ", metodoPago=" + metodoPago + ", fechaPago="
				+ fechaPago + "]";
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

	private Button getNewTicketButton() { /// sentidosDesktopJava/src/images/reservation.png
		Button btn = new Button();
		Image imgLupa = new Image("/images/icons8_Search_52px.png");
		ImageView lupa = new ImageView();
		lupa.setImage(imgLupa);
		btn.setGraphic(lupa);
		btn.setScaleX(0.5);
		btn.setScaleY(0.5);
		btn.addEventFilter(MouseEvent.MOUSE_CLICKED, eventClickLupa);
		btn.setStyle(
				"-fx-padding:-5px;-fx-border-insets: -5px;-fx-background-insets: -5px; -fx-background-color: transparent;");
		btn.setCursor(Cursor.HAND);
		return btn;
	}

	EventHandler<MouseEvent> eventClickLupa = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {
			System.out.println("clickeo en reserva: " + this);

		}
	};

	EventHandler<MouseEvent> eventClickEliminar = new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent event) {
			System.out.println("clickeo en eliminar");
			HttpTicketService ticketService = new HttpTicketService();
			if (ticketService.borrarTicket("{\"id\":" + id + "}")) {
				NotificationType notification = NotificationType.SUCCESS;

				TrayNotification pushNot = new TrayNotification();
				pushNot.setNotificationType(notification);
				pushNot.setTitle("Ticket");
				pushNot.setMessage("Ticket eliminada con exito!");
				pushNot.setAnimationType(AnimationType.POPUP);
				pushNot.showAndDismiss(Duration.seconds(2)); 
				pushNot.showAndWait();
				((Controller) Main.contexto.get("controller")).actualizarTablaTickets();
			} else {
				NotificationType notification = NotificationType.ERROR;

				TrayNotification pushNot = new TrayNotification();
				pushNot.setNotificationType(notification);
				pushNot.setTitle("Ticket");
				pushNot.setMessage("Ah ocurrido un problema!! Vuelva a intentar.");
				pushNot.setAnimationType(AnimationType.POPUP);
				pushNot.showAndDismiss(Duration.seconds(2));
				pushNot.showAndWait();
			}
		}
	};
	public void print (String m) {
		System.out.println(m);
	}
	EventHandler<MouseEvent> eventClickEditar = new EventHandler<MouseEvent>() {
		
		@Override
		public void handle(MouseEvent event) {
			panelEditar.setVisible(true);
			panelEditar.toFront();	
			System.out.println("clickeo en editar ticket");
		}
	};
}
