package home;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.LoginResponse;
import model.OrderDetail;
import model.OrderResponse;
import model.ReservaList;
import model.ReservaTableItem;
import model.Reservations;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Servicios.HttpReservaService;

public class Controller implements Initializable, EventHandler<ActionEvent> {

	@FXML
	private VBox pnItems = null;

	@FXML
	private Button btnIngresar;

	@FXML
	private Button btnOverview;

	@FXML
	private Button btnOrders;

	@FXML
	private Button btnCustomers;

	@FXML
	private Button btnMenus;

	@FXML
	private Button btnPackages;

	@FXML
	private Button btnSettings;

	@FXML
	private Button btnClose;

	@FXML
	private Button btnSignout;

	@FXML
	private Pane pnReservacion;

	@FXML
	private Pane pnTicket;

	@FXML
	private Pane pnOrden;

	@FXML
	private Pane pnLateral;

	@FXML
	private Pane pnLateralTicket;

	@FXML
	private Pane pnLateralReserva;

	@FXML
	private Pane pnLateralOrden;

	@FXML
	private Pane pnLateralSalir;

	@FXML
	private Pane pnFondo;

	@FXML
	private Pane pnLogin;

	@FXML
	private Pane pnNuevoReserva;

	@FXML
	private Pane pnNuevoOrden;

	@FXML
	private Pane pnNuevoTicket;

	@FXML
	private TextField textUser;

	@FXML
	private Text textClaveError;

	@FXML
	private Text textLoginError;

	@FXML
	private Text textUsuarioError;

	@FXML
	private Text txtNuevoReservacion;

	@FXML
	private Text txtNuevoOrden;

	@FXML
	private Text txtNuevoTicket;

	@FXML
	private ImageView imgNuevoResarvacion;

	@FXML
	private ImageView imgNuevoOrden;

	@FXML
	private ImageView imgNuevoTicket;

	@FXML
	private PasswordField textPassword;

	@FXML
	private Label warning;

	@FXML
	private TableView<ReservaTableItem> tbReservacion;

	@FXML
	private TableColumn<ReservaTableItem, String> clMesa;

	@FXML
	private TableColumn<ReservaTableItem, String> clId;

	@FXML
	private TableColumn<ReservaTableItem, String> clUsuario;

	@FXML
	private TableColumn<ReservaTableItem, String> clFecha;

	@FXML
	private TableColumn<ReservaTableItem, String> clConfirmado;

	@FXML
	private TableColumn<ReservaTableItem, String> clTe_comida;

	@FXML
	private TableColumn<ReservaTableItem, String> clHora;

	@FXML
	private TableColumn<ReservaTableItem, String> clReserva;

	@FXML
	private TableColumn<ReservaTableItem, String> clEditar;

	@FXML
	private TableColumn<ReservaTableItem, String> clEliminar;

	Stage stage;

	private HttpService http = new HttpService();
	private HttpReservaService httpReserva = new HttpReservaService();

	@Override
	public void handle(ActionEvent actionEvent) {
		/*
		 * // TODO Auto-generated method stub Button btn = (Button)
		 * actionEvent.getSource(); System.out.println(http.hashCode()); if
		 * (btn.getId().equals("btnClose")) { stage = (Stage)
		 * btn.getScene().getWindow(); stage.close(); }else
		 * if(actionEvent.getSource()==btnLogin) {
		 * 
		 * System.out.println(username.toString()); http.login(username.getText(),
		 * password.getText()); verifyLogin();
		 * 
		 * }else { System.out.println(btn.getId()); }
		 */
	}

	private void verifyLogin() {
		LoginResponse login = (LoginResponse) Main.contexto.get("login");

		if (login.getAccess_token() != null) {
			setBtnVisible();
			httpReserva.todasLasReservas();
		} else {
			textLoginError.setText("Ocurrio un error, intente nuevamente.");
			textLoginError.setVisible(true);
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// loginToFrontt();
		// btnClose.setOnAction(this);
		// btnLogin.setOnAction(this);
		// warning.setVisible(false);

		pnLateralSalir.addEventFilter(MouseEvent.MOUSE_ENTERED, evenEntertLateralMenu);
		pnLateralOrden.addEventFilter(MouseEvent.MOUSE_ENTERED, evenEntertLateralMenu);
		pnLateralReserva.addEventFilter(MouseEvent.MOUSE_ENTERED, evenEntertLateralMenu);
		pnLateralTicket.addEventFilter(MouseEvent.MOUSE_ENTERED, evenEntertLateralMenu);

		pnLateralSalir.addEventFilter(MouseEvent.MOUSE_EXITED, eventExitedLateralMenu);
		pnLateralOrden.addEventFilter(MouseEvent.MOUSE_EXITED, eventExitedLateralMenu);
		pnLateralReserva.addEventFilter(MouseEvent.MOUSE_EXITED, eventExitedLateralMenu);
		pnLateralTicket.addEventFilter(MouseEvent.MOUSE_EXITED, eventExitedLateralMenu);

		pnLateralSalir.addEventFilter(MouseEvent.MOUSE_CLICKED, eventClickLateralMenu);
		pnLateralOrden.addEventFilter(MouseEvent.MOUSE_CLICKED, eventClickLateralMenu);
		pnLateralReserva.addEventFilter(MouseEvent.MOUSE_CLICKED, eventClickLateralMenu);
		pnLateralTicket.addEventFilter(MouseEvent.MOUSE_CLICKED, eventClickLateralMenu);

		pnNuevoReserva.addEventFilter(MouseEvent.MOUSE_PRESSED, eventResaltarLetra);
		pnNuevoOrden.addEventFilter(MouseEvent.MOUSE_PRESSED, eventResaltarLetra);
		pnNuevoTicket.addEventFilter(MouseEvent.MOUSE_PRESSED, eventResaltarLetra);
		pnNuevoReserva.addEventFilter(MouseEvent.MOUSE_RELEASED, eventNoResaltarLetra);
		pnNuevoOrden.addEventFilter(MouseEvent.MOUSE_RELEASED, eventNoResaltarLetra);
		pnNuevoTicket.addEventFilter(MouseEvent.MOUSE_RELEASED, eventNoResaltarLetra);

	}

	private void loginToFrontt() {
		// btnCustomers.setVisible(false);
		// btnMenus.setVisible(false);
		// btnOverview.setVisible(false);
		// btnOrders.setVisible(false);
		// btnPackages.setVisible(false);
		// btnSignout.setVisible(false);
		// pnLogin.setStyle("-fx-background-color : #1620A1");
		// pnLogin.toFront();
	}

	private void setBtnVisible() {
		LoginResponse login = (LoginResponse) Main.contexto.get("login");
		List<String> roles = new ArrayList<>();
		login.getRoles().forEach(role -> {
			roles.add(role.getRolName());
		});

		System.out.println("ROLES: " + roles);

		if (roles == null || roles.size() == 0)
			return;

		if (roles.contains("ROLE_ADMIN")) {
			pnLogin.setVisible(false);
			pnFondo.setVisible(false);
			pnTicket.setVisible(true);
			pnLateral.setVisible(true);
			pnOrden.setVisible(true);
			pnReservacion.setVisible(true);

		} else if (roles.contains("ROLE_MOZO")) {
			pnLogin.setVisible(false);
			pnFondo.setVisible(false);
			pnLateral.setVisible(true);
			pnOrden.setVisible(true);
		} else if (roles.contains("ROLE_MAITRE")) {
			pnLogin.setVisible(false);
			pnFondo.setVisible(false);
			pnLateral.setVisible(true);
			pnReservacion.setVisible(true);
		} else if (roles.contains("ROLE_CAJA")) {
			pnLogin.setVisible(false);
			pnFondo.setVisible(false);
			pnTicket.setVisible(true);
			pnLateral.setVisible(true);
		} else {
			textLoginError.setText("Usted no cuenta con permisos para ingresar al sistema. \nIntente con otra cuenta.");
		}

		actualizarTablaReservas();

	}

	public void handleClicks(ActionEvent actionEvent) {
		/*
		 * System.out.println("aca"); if (actionEvent.getSource() == btnCustomers) {
		 * pnlCustomer.setStyle("-fx-background-color : #1620A1");
		 * pnlCustomer.toFront(); } if (actionEvent.getSource() == btnMenus) {
		 * pnlMenus.setStyle("-fx-background-color : #53639F"); pnlMenus.toFront(); } if
		 * (actionEvent.getSource() == btnOverview) {
		 * pnlOverview.setStyle("-fx-background-color : #02030A");
		 * pnlOverview.toFront(); } if(actionEvent.getSource()==btnOrders) {
		 * pnlOrders.setStyle("-fx-background-color : #464F67"); pnlOrders.toFront(); }
		 */
	}

	private String stateToString(Integer n) {
		if (n == 0)
			return "pendiente";
		if (n == 1)
			return "procesando";
		if (n == 2)
			return "terminado";
		return "indefinido";
	}

	private String totalOrder(OrderResponse order) {
		double total = 0;
		for (OrderDetail detail : order.getOrderDetails()) {
			System.out.println(detail.getMenu().toString());

			Double price = detail.getMenu().getPrice();
			System.out.println("price: " + price);
			total += price * detail.getQuantity();
		}
		return total + "";
	}

	private void rellenarReservas() {
		ReservaList orders = httpReserva.todasLasReservas();

	}

	

	/// nueva aplicacion
	private Boolean verificarNombreDeUsuario() {

		if (textUser.getText().length() > 4)
			return true;

		return false;
	}

	private Boolean verificarClave() {
		// Regex to check valid password.
		String regex = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%._-]).{8,20})";
		String regexMin = "(?=.*[a-z])";
		String regexMay = "(?=.*[A-Z])";
		String regexNum = "(?=.*\\\\d)";
		String regexEsp = "(?=.*[@#$%._-])";
		String regexLong = ".{8,20}";

		// Compile the ReGex
		// Compile the ReGex
		Pattern p = Pattern.compile(regex);
		Pattern pregexMin = Pattern.compile(regexMin);
		Pattern pregexMay = Pattern.compile(regexMay);
		Pattern pregexNum = Pattern.compile(regexNum);
		Pattern pregexEsp = Pattern.compile(regexEsp);
		Pattern pregexLong = Pattern.compile(regexLong);

		if (textPassword.getText() == null) {
			return false;
		}

		Matcher m = p.matcher(textPassword.getText());
		Matcher mregexMin = pregexMin.matcher(textPassword.getText());
		Matcher mregexMay = pregexMay.matcher(textPassword.getText());
		Matcher mregexNum = pregexNum.matcher(textPassword.getText());
		Matcher mregexEsp = pregexEsp.matcher(textPassword.getText());
		Matcher mpregexLong = pregexLong.matcher(textPassword.getText());

		System.out.println("Min: " + mregexMin.matches());
		System.out.println("may: " + mregexMay.matches());
		System.out.println("num: " + mregexNum.matches());
		System.out.println("esp: " + mregexEsp.matches());
		System.out.println("long: " + mpregexLong.matches());

		return m.matches();
	}

	public void handleIngresar(MouseEvent event) {
		Boolean complejidad = verificarClave();
		Boolean longUsuario = verificarNombreDeUsuario();
		textUsuarioError.setText("");
		textClaveError.setText("");
		textClaveError.setVisible(false);
		textUsuarioError.setVisible(false);
		if (!complejidad) {
			textClaveError.setText(
					"La clave debe tener minimo 8 caracteres,\n1 mayuscula, 1 minuscula y 1 caracter especial.");
			textClaveError.setVisible(true);
		}

		if (!longUsuario) {
			textUsuarioError.setText("El usuario debe tener un minumo de 5 caracteres.");
			textUsuarioError.setVisible(true);
		}

		if (longUsuario && complejidad) {

			System.out.println(textUser.toString());
			http.login(textUser.getText(), textPassword.getText());
			verifyLogin();
		}
	}

	EventHandler<MouseEvent> evenEntertLateralMenu = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {
			String id = ((Pane) event.getSource()).getId();
			Pane panel = (Pane) event.getSource();
			panel.setStyle("-fx-background-color:#7800FF;");
			System.out.println(id);
		}
	};

	EventHandler<MouseEvent> eventExitedLateralMenu = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {
			String id = ((Pane) event.getSource()).getId();
			Pane panel = (Pane) event.getSource();
			panel.setStyle("-fx-background-color:transparent;");
			System.out.println(id);
		}
	};

	EventHandler<MouseEvent> eventClickLateralMenu = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {
			String id = ((Pane) event.getSource()).getId();
			Pane panel = (Pane) event.getSource();
			if (id.equals("pnLateralTicket")) {
				pnTicket.setVisible(true);
				pnTicket.toFront();
			} else if (id.equals("pnLateralOrden")) {
				pnOrden.setVisible(true);

				pnOrden.toFront();
			} else if (id.equals("pnLateralReserva")) {
				pnReservacion.setVisible(true);

				pnReservacion.toFront();
			} else if (id.equals("pnLateralSalir")) {
				pnLogin.setVisible(true);
				pnFondo.setVisible(true);
				pnFondo.toFront();
				pnLogin.toFront();
				Main.contexto.clear();
			}
		}
	};

	EventHandler<MouseEvent> eventResaltarLetra = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {
			Color color = Color.web("#FF54B9", 1);
			DropShadow dropShadow = new DropShadow();
			dropShadow.setBlurType(BlurType.GAUSSIAN);
			dropShadow.setColor(color);
			dropShadow.setHeight(5);
			dropShadow.setWidth(5);
			dropShadow.setRadius(5);
			dropShadow.setOffsetX(0);
			dropShadow.setOffsetY(0);
			dropShadow.setSpread(12);
			String id = ((Pane) event.getSource()).getId();
			Pane panel = (Pane) event.getSource();
			if (id.equals("pnNuevoReserva")) {
				System.out.println("id: " + id);

				imgNuevoResarvacion.setEffect(dropShadow);
				txtNuevoReservacion.setStyle("-fx-fill:#FF54B9;");

			} else if (id.equals("pnNuevoTicket")) {
				System.out.println("id: " + id);
				imgNuevoTicket.setEffect(dropShadow);
				txtNuevoTicket.setStyle("-fx-fill:#FF54B9;");
			} else if (id.equals("pnNuevoOrden")) {
				System.out.println("id: " + id);
				imgNuevoOrden.setEffect(dropShadow);
				txtNuevoOrden.setStyle("-fx-fill:#FF54B9;");
			} else {
				System.out.println("id: " + id);
			}
		}
	};

	EventHandler<MouseEvent> eventNoResaltarLetra = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {

			String id = ((Pane) event.getSource()).getId();
			Pane panel = (Pane) event.getSource();
			if (id.equals("pnNuevoReserva")) {
				System.out.println("id: " + id);
				imgNuevoResarvacion.setEffect(null);
				txtNuevoReservacion.setStyle("-fx-fill:#000000;");
			} else if (id.equals("pnNuevoTicket")) {
				System.out.println("id: " + id);
				imgNuevoTicket.setEffect(null);
				txtNuevoTicket.setStyle("-fx-fillr:#000000;");
			} else if (id.equals("pnNuevoOrden")) {
				System.out.println("id: " + id);
				imgNuevoOrden.setEffect(null);
				txtNuevoOrden.setStyle("-fx-fill:#000000;");
			} else {
				System.out.println("id: " + id);
			}
		}
	};

	EventHandler<MouseEvent> evcentClickReserva = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {
			System.out.println("clickeo en reserva: " + tbReservacion.getSelectionModel().getSelectedItem().toString());

		}
	};

	EventHandler<MouseEvent> evcentClickEliminar = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {
			System.out.println("clickeo en eliminar");
		}
	};

	EventHandler<MouseEvent> evcentClickEditar = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {
			System.out.println("clickeo en editar");
		}
	};

	EventHandler<MouseEvent> ocultarEditar = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {
			((Pane)((Button)((Text)event.getTarget()).getParent()).getParent()).setVisible(false);
		}
	};
	
	EventHandler<MouseEvent> enviarReservaEditada = new EventHandler<MouseEvent>() {
		String usuario;
		Long id;
		Integer mesa;
		String fecha; 
		Boolean confirmado;
		Boolean isTea;
		Boolean hora;		
		@Override
		public void handle(MouseEvent event) {
			System.out.println((((Text)event.getTarget()).getParent()).getParent().getId());
			Pane pane =  (Pane)((Button)((Text)event.getTarget()).getParent()).getParent();
			pane.setVisible(false);			
			pane.getChildren().forEach(c ->{
				System.out.println(c.toString());
				if("id".equals(c.getId())) {
					Text txtid = (Text) c;
					id=Long.parseLong(txtid.getText());
				}
				else if("mesa".equals(c.getId())) {
					TextField txtMesa = (TextField) c;
					mesa=Integer.parseInt(txtMesa.getText());
				}else if("usuario".equals(c.getId())) {
					TextField txtUsuario = (TextField) c;
					usuario=txtUsuario.getText();
				}else if("fecha".equals(c.getId())) {
					DatePicker dateP=(DatePicker) c;
					LocalDate lclDate = dateP.getValue();
					LocalDate localDate = LocalDate.now();
					String dateFormat = "yyyy-MM-dd";
					String formattedDate = lclDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
					String[] dateArray= formattedDate.split("-");
					System.out.println("LONG format: " + formattedDate);
					
					fecha = formattedDate;
					
				}else if("confirmado".equals(c.getId())) {
					ComboBox<String> combo = (ComboBox<String>) c;
					Boolean valor=null;
					if("Si".equals(combo.getValue())) {
						valor=Boolean.TRUE;
					}else if("No".equals(combo.getValue())) {
						valor=Boolean.FALSE;
					}
					confirmado=valor;
				}else if("isTea".equals(c.getId())) {
					ComboBox<String> combo = (ComboBox<String>) c;
					Boolean valor=null;
					if("Té".equals(combo.getValue())) {
						valor=Boolean.TRUE;
					}else if("Comida".equals(combo.getValue())) {
						valor=Boolean.FALSE;
					}
					isTea= valor;
				}else if("hora".equals(c.getId())) {
					ComboBox<String> combo = (ComboBox<String>) c;
					Boolean valor=null;
					if("8:00 - 11:00".equals(combo.getValue())) {
						valor=Boolean.TRUE;
					}else if("11:00 - 15:00".equals(combo.getValue())) {
						valor=Boolean.FALSE;
					}else if("15:00 - 19:00".equals(combo.getValue())) {
						valor=Boolean.FALSE;
					}else if("19:00 - 00:00".equals(combo.getValue())) {
						valor=Boolean.FALSE;
					}
					hora= valor;
				}				
			});
			System.out.println("antes de ingreso");
			System.out.println("hora: "+hora+", es te:" +isTea+", confirmado: "+confirmado+", fecha"+fecha+", usuario: "+usuario
					+", mesa"+mesa);

			if(hora!= null && isTea!=null && confirmado!=null && fecha!= null && usuario != null && mesa != null ) {
									
				String json = "{"
					    +"\"id\":"+id+","
					    +"\"table\":"+mesa+","
					    +"\"fecha\":"+"\""+fecha+"\","
					    +"\"username\":"+"\""+usuario+"\","
					    +"\"confirmado\":"+confirmado+","
					    +"\"isTea\":"+isTea+","
					    +"\"hora\":"+hora
					    +"}";
				if(httpReserva.actualizarReserva(json)) {
					System.out.println("ingreso");
					actualizarTablaReservas();
				}		
				System.out.println("no ingreso");

			}			
		}
	};
	
	private void actualizarTablaReservas() {
		tbReservacion.getItems().clear();
		List<ReservaTableItem> reservas = new ArrayList<>();
		((List<Reservations>) Main.contexto.get("reservas")).forEach(r -> {
			// Button btnReserva = getNewReservaButton();
			Pane pane = new Pane();
			pane.setId("panelEditar");
			pane.setPrefWidth(400);
			pane.setPrefHeight(500);
			pane.setMaxWidth(1500);
			pane.setMaxHeight(1500);
			pane.setLayoutX(250);
			pane.setLayoutY(30);

			Button aceptar = new Button("ACEPTAR");
			Button cancelar = new Button("CANCELAR");
			cancelar.addEventFilter(MouseEvent.MOUSE_CLICKED, ocultarEditar);
			aceptar.addEventFilter(MouseEvent.MOUSE_CLICKED, enviarReservaEditada);
			cancelar.setId("btnCancelar");
			aceptar.setId("btnAceptar");
			TextField inputTable = new TextField();
			inputTable.setPromptText("Numero de mesa");
			inputTable.setId("mesa");
			inputTable.setText(r.getTable()+"");
			Text txtTable = new  Text("Nro° Mesa :");
			
			TextField inputUsuario = new TextField();
			inputUsuario.setPromptText("Nombre de usuario");
			inputUsuario.setId("usuario");
			Text txtUsuario = new  Text("Usuario");			
			
			DatePicker date = new DatePicker();
			date.setId("fecha");
			System.out.println("fecha: "+r.getDateReservationString());
			String[] result = r.getDateReservationString().split("-");
			System.out.println("dia: "+result[0]);
			LocalDate lclDate = LocalDate.of(Integer.parseInt(result[0]), Integer.parseInt(result[1]), Integer.parseInt(result[2]));
			date.setValue(lclDate);
			ComboBox<String> comboConfim = new ComboBox<>(FXCollections.observableArrayList("Si", "No"));
			ComboBox<String> comboComida = new ComboBox<>(FXCollections.observableArrayList("Té", "Comida"));
			ComboBox<String> comboHora = new ComboBox<>(FXCollections.observableArrayList("8:00 - 11:00",
					"11:00 - 15:00", "15:00 - 19:00", "19:00 - 00:00"));
			comboConfim.setId("confirmado");
			comboComida.setId("isTea");
			comboHora.setId("hora");
			comboConfim.setValue(r.getConfirmed()?"Si":"No");
			comboComida.setValue(r.getIsTea()?"Té":"Comida");
			comboHora.setValue(r.getIsTea()?(r.getHour()?"8:00 - 11:00":"15:00 - 19:00"):(r.getHour()?"11:00 - 15:00":"19:00 - 00:00"));
			Text fecha = new Text("Fecha :");
			Text id = new Text(r.getId()+"");
			id.setId("id");
			id.setVisible(false);
			Text comida = new Text("Té / Comida :");
			Text hora = new Text("Hora :");
			Text confirm = new Text("Confirmado :");
			Text titulo = new Text("Editar Reserva");
			List<Stop> stops = new ArrayList<>();
			Color color2 = Color.rgb(122, 4, 255);
			Color color1 = Color.rgb(255, 4, 196);
			stops.add(new Stop(0, color1));
			stops.add(new Stop(1, color2));
			LinearGradient gradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);
			titulo.setFill(gradient);			
			titulo.setStyle("-fx-font: 24 arial;");
			comida.setFill(gradient);
			hora.setFill(gradient);
			fecha.setFill(gradient);
			confirm.setFill(gradient);
			txtUsuario.setFill(gradient);
		
			pane.getChildren().add(txtUsuario);
			pane.getChildren().add(inputUsuario);
			pane.getChildren().add(date);
			pane.getChildren().add(comboConfim);
			pane.getChildren().add(comboComida);
			pane.getChildren().add(comboHora);
			pane.getChildren().add(fecha);
			pane.getChildren().add(comida);
			pane.getChildren().add(hora);
			pane.getChildren().add(confirm);
			pane.getChildren().add(cancelar);
			pane.getChildren().add(aceptar);
			pane.getChildren().add(titulo);
			pane.getChildren().add(id);
			pane.getChildren().add(inputTable);
			pane.setVisible(false);
			pane.setStyle("-fx-background-color: #ffffff");

			date.setLayoutX(150);
			date.setLayoutY(150);
			fecha.setLayoutX(30);
			fecha.setLayoutY(170);

			comboConfim.setLayoutX(150);
			comboConfim.setLayoutY(200);
			confirm.setLayoutX(30);
			confirm.setLayoutY(220);

			comboComida.setLayoutX(150);
			comboComida.setLayoutY(250);
			comida.setLayoutX(30);
			comida.setLayoutY(270);

			comboHora.setLayoutX(150);
			comboHora.setLayoutY(300);
			hora.setLayoutX(30);
			hora.setLayoutY(320);
			
			inputUsuario.setLayoutX(150);
			inputUsuario.setLayoutY(350);
			inputUsuario.setText(r.getUsername());
			txtUsuario.setLayoutX(30);
			txtUsuario.setLayoutY(360);

			aceptar.setLayoutX(50);
			aceptar.setLayoutY(450);

			cancelar.setLayoutX(300);
			cancelar.setLayoutY(450);

			titulo.setLayoutX(100);
			titulo.setLayoutY(100);
			// padre.getChildren().add(pane);

			pane.toBack();
			pnReservacion.getChildren().add(pane);
			
			ReservaTableItem item = new ReservaTableItem(r.getId(), r.getTable(), r.getUsername(),
					r.getDateReservationString(), r.getConfirmed(), r.getIsTea(), r.getHour());
			item.setPanelEditar(pane);
			reservas.add(item);
		});
		ObservableList<ReservaTableItem> datos = FXCollections.observableList(reservas);

		clMesa.setCellValueFactory(new PropertyValueFactory<ReservaTableItem, String>("Mesa"));

		clId.setCellValueFactory(new PropertyValueFactory<ReservaTableItem, String>("Id"));

		clUsuario.setCellValueFactory(new PropertyValueFactory<ReservaTableItem, String>("Usuario"));

		clFecha.setCellValueFactory(new PropertyValueFactory<ReservaTableItem, String>("Fecha"));

		clConfirmado.setCellValueFactory(new PropertyValueFactory<ReservaTableItem, String>("Confirmado"));

		clTe_comida.setCellValueFactory(new PropertyValueFactory<ReservaTableItem, String>("Te_Comida"));

		clHora.setCellValueFactory(new PropertyValueFactory<ReservaTableItem, String>("Hora"));

		clReserva.setCellValueFactory(new PropertyValueFactory<ReservaTableItem, String>("Reserva"));

		clEditar.setCellValueFactory(new PropertyValueFactory<ReservaTableItem, String>("Editar"));

		clEliminar.setCellValueFactory(new PropertyValueFactory<ReservaTableItem, String>("Eliminar"));

		datos.forEach(d -> tbReservacion.getItems().add(d));
	}

}
