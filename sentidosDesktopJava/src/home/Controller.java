package home;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.LoginResponse;
import model.OrderDetail;
import model.OrderList;
import model.OrderResponse;
import model.ReservaList;
import model.ReservaTableItem;
import model.Reservations;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Servicios.HttpReservaService;

public class Controller implements Initializable , EventHandler<ActionEvent>{

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
    private TableColumn<ReservaTableItem, String> clUsuario;
    
    @FXML
    private TableColumn<ReservaTableItem, String> clFecha;
    
    @FXML
    private TableColumn<ReservaTableItem, String> clConfirmado;
    
    @FXML
    private TableColumn<ReservaTableItem, String> clTe_comida;
    
    @FXML
    private TableColumn<ReservaTableItem, String> clHora;
    
    Stage stage;    
  
    private HttpService http = new HttpService();
    private HttpReservaService httpReserva = new HttpReservaService();
    
    @Override
	public void handle(ActionEvent actionEvent) {
	/*	// TODO Auto-generated method stub
    	Button btn = (Button) actionEvent.getSource();    	
    	System.out.println(http.hashCode());
    	if (btn.getId().equals("btnClose")) {
    		stage = (Stage) btn.getScene().getWindow();
        	stage.close();
    	}else if(actionEvent.getSource()==btnLogin) {
            
        	System.out.println(username.toString());      	   
        	http.login(username.getText(), password.getText());
        	verifyLogin();        	
        
    	}else 
    	{
    		System.out.println(btn.getId());
    	}
    	*/
	}
    
    private void verifyLogin() {
    	LoginResponse login =(LoginResponse) Main.contexto.get("login");
    	
    	if(login.getAccess_token() != null) {
    		setBtnVisible();    	
    		httpReserva.todasLasReservas();
    	}else{
    		textLoginError.setText("Ocurrio un error, intente nuevamente.");
    		textLoginError.setVisible(true);
    	}
    }
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	
    	//loginToFrontt();
    	//btnClose.setOnAction(this);
    	//btnLogin.setOnAction(this);
    	//warning.setVisible(false);
    	
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
    	//btnCustomers.setVisible(false);
    	//btnMenus.setVisible(false);
    	//btnOverview.setVisible(false);
    	//btnOrders.setVisible(false);
    	//btnPackages.setVisible(false);
    	//btnSignout.setVisible(false);
    	//pnLogin.setStyle("-fx-background-color : #1620A1");
    	//pnLogin.toFront();    	
    }
    
    private void setBtnVisible() {
    	LoginResponse login =(LoginResponse) Main.contexto.get("login");
    	List<String> roles = new ArrayList<>();
    	login.getRoles().forEach(role ->{
    		roles.add(role.getRolName());
    	});
    	
    	System.out.println("ROLES: "+roles);
    	
    	if(roles == null || roles.size() == 0) return;
    	
    	if(roles.contains("ROLE_ADMIN")) {
    		pnLogin.setVisible(false);
    		pnFondo.setVisible(false);
    		pnTicket.setVisible(true);
    		pnLateral.setVisible(true);
    		pnOrden.setVisible(true);
    		pnReservacion.setVisible(true);
    		
    	}else if (roles.contains("ROLE_MOZO")) {
    		pnLogin.setVisible(false);
    		pnFondo.setVisible(false);
    		pnLateral.setVisible(true);
    		pnOrden.setVisible(true);
    	}else if(roles.contains("ROLE_MAITRE")) {
    		pnLogin.setVisible(false);
    		pnFondo.setVisible(false);
    		pnLateral.setVisible(true);
    		pnReservacion.setVisible(true);
    	}else if(roles.contains("ROLE_CAJA")) {
    		pnLogin.setVisible(false);
    		pnFondo.setVisible(false);
    		pnTicket.setVisible(true);
    		pnLateral.setVisible(true);
    	}else {
    		textLoginError.setText("Usted no cuenta con permisos para ingresar al sistema. \nIntente con otra cuenta.");
    	}
    	/*if(roles.contains("ROLE_ADMIN")) {
    		//System.out.println("seccion admin");
	    	//btnCustomers.setVisible(true);
	    	//btnMenus.setVisible(true);
	    	//btnOverview.setVisible(true);
	    	//btnOrders.setVisible(true);
	    	//btnPackages.setVisible(true);
	    	//btnSignout.setVisible(true);    	
	       //pnLogin.setVisible(false);
	    	//pnlOverview.setStyle("-fx-background-color : #02030A");
	    	//pnlOverview.toFront();
    		//rellenarOrdenes();

    	}else if (roles.contains("ROLE_MOZO")) {
    		System.out.println("seccion mozo");

    		btnOrders.setVisible(true);
	    	pnLogin.setVisible(false);
	    	pnlOrders.toFront();
	    	pnlOrders.setVisible(true);
	    	pnlOverview.setVisible(false);
    		rellenarOrdenes();

    	}else if(roles.contains("ROLE_MAITRE")) {
    		System.out.println("seccion maitre");

	    	pnLogin.setVisible(false);
	    	pnlMenus.toFront();
	    	pnlMenus.setVisible(true);

	    	pnlOverview.setVisible(false);
	    	btnMenus.setVisible(true);
    	}else if(roles.contains("ROLE_CAJA")) {
    		System.out.println("seccion caja");

	    	pnLogin.setVisible(false);
	    	pnlCustomer.setVisible(true);
	    	pnlCustomer.toFront();
	    	pnlOverview.setVisible(false);
	    	btnCustomers.setVisible(true);
    	}
    	*/
        actualizarTablaReservas();

    }

    public void handleClicks(ActionEvent actionEvent) {
    /*	System.out.println("aca");
        if (actionEvent.getSource() == btnCustomers) {
            pnlCustomer.setStyle("-fx-background-color : #1620A1");
            pnlCustomer.toFront();
        }
        if (actionEvent.getSource() == btnMenus) {
           pnlMenus.setStyle("-fx-background-color : #53639F");
            pnlMenus.toFront();
        }
        if (actionEvent.getSource() == btnOverview) {
            pnlOverview.setStyle("-fx-background-color : #02030A");
            pnlOverview.toFront();
        }
        if(actionEvent.getSource()==btnOrders)
        {
            pnlOrders.setStyle("-fx-background-color : #464F67");
            pnlOrders.toFront();
        }  */                      
    }

    private String stateToString(Integer n) {
    	if(n==0) return "pendiente";
    	if(n==1) return "procesando";
    	if(n==2) return "terminado";
    	return "indefinido";
    }
    
    private String totalOrder(OrderResponse order) {
    	double total= 0;
    	for (OrderDetail detail : order.getOrderDetails()) {
        	System.out.println(detail.getMenu().toString());

    		Double price= detail.getMenu().getPrice();
    		System.out.println("price: "+price);
			total +=price*detail.getQuantity();
		}
    	return total+"";
    }
    
    private void rellenarReservas() {
    	ReservaList orders= httpReserva.todasLasReservas(); 
    	
    }
    
    private void rellenarOrdenes() {
    	OrderList orders= http.orders(); 
    	List<OrderResponse> orderList = orders.getOrders();
    	System.out.println("longitud : "+orders);
    	
	    if(orderList != null && orderList.size() >0) {
	        Node[] nodes = new Node[orderList.size()];
	        for (int i = 0; i < nodes.length; i++) {
	        	OrderResponse order = orderList.get(i);
	            try {	
	            	
	                final int j = i;
	                
	                HBox load = FXMLLoader.load(getClass().getResource("Item.fxml"));
	                ObservableList<Node> childs= load.getChildren();
	                
	                System.out.println("0: "+childs.get(0).getId());	   
	                System.out.println("1: "+childs.get(1).getId());	   
	                System.out.println("2: "+childs.get(2).getId());	   
	                System.out.println("3: "+childs.get(3).getId());	   
	                System.out.println("4: "+childs.get(4).getId());	   
	                System.out.println("5: "+childs.get(5).getId());	   
	                
	                Label mesa = (Label) childs.get(1);
	                Label fecha= (Label) childs.get(2);
	                Label usuario = (Label) childs.get(3);
            		Label total = (Label) childs.get(4);
            		Button estado = (Button) childs.get(5);
            		//Label orden = (Label) childs.get(0);

            		childs.clear();
	                
	                System.out.println("1 mesa");	                
	                mesa.setText("1");
            		childs.add(mesa);
            		
	                System.out.println("2 fecha");	
	                Date date = order.getCreateAt();	                		
            		Calendar calendar = new GregorianCalendar();
            		calendar.setTime(date);
            		int year = calendar.get(Calendar.YEAR);
            		//Add one to month {0 - 11}
            		int month = calendar.get(Calendar.MONTH) + 1;
            		int day = calendar.get(Calendar.DAY_OF_MONTH);
            		
            		fecha.setText(day+"/"+month+"/"+year);
            		
            		childs.add(fecha);  
	                
            		
	               
            		
	                System.out.println("3 usuario");
	                usuario.setText(order.getCustomerDto().getUsername());
            		childs.add(usuario);
	                	                 
            		
            		System.out.println("4 total");	
             		total.setText("$".concat(totalOrder(order)));
             		childs.add(total);
            		
	                
            		
	                System.out.println("5 estado");
	                estado.setText(stateToString( order.getState()));
            		childs.add(estado);
	                
	               
	                
	                System.out.println("0 orden");

	               
	                
	                System.out.println("\n");
	                //nodes[i] = FXMLLoader.load(getClass().getResource("Item.fxml"));
	                nodes[i]= (Node) load;
	               
	                
	                //give the items some effect                 
	                nodes[i].setOnMouseEntered(event -> {
	                    nodes[j].setStyle("-fx-background-color : #0A0E3F");
	                });
	                nodes[i].setOnMouseExited(event -> {
	                    nodes[j].setStyle("-fx-background-color : #02030A");
	                });
	                pnItems.getChildren().add(nodes[i]);
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
    	}
    }
	
    
    /// nueva aplicacion
    private Boolean verificarNombreDeUsuario() {
    	
    	if(textUser.getText().length() >4  ) return true;
    	
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
        
        System.out.println("Min: "+mregexMin.matches());
        System.out.println("may: "+mregexMay.matches());
        System.out.println("num: "+mregexNum.matches());
        System.out.println("esp: "+mregexEsp.matches());
        System.out.println("long: "+mpregexLong.matches());
        
        return m.matches();
    }
    
    public void handleIngresar(MouseEvent event) { 
    	Boolean complejidad = verificarClave();
    	Boolean longUsuario = verificarNombreDeUsuario();
    	textUsuarioError.setText("");
		textClaveError.setText("");
		textClaveError.setVisible(false);
		textUsuarioError.setVisible(false);
    	if(!complejidad) {
    		textClaveError.setText("La clave debe tener minimo 8 caracteres,\n1 mayuscula, 1 minuscula y 1 caracter especial.");
    		textClaveError.setVisible(true);
    	}
    	
    	if(!longUsuario) {
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
        	String id =((Pane) event.getSource()).getId();
        	Pane panel = (Pane) event.getSource();
        	panel.setStyle("-fx-background-color:#7800FF;");
        	System.out.println(id);
        } 
     };  
    
     EventHandler<MouseEvent> eventExitedLateralMenu = new EventHandler<MouseEvent>() { 
         @Override 
         public void handle(MouseEvent event) {
         	String id =((Pane) event.getSource()).getId();
         	Pane panel = (Pane) event.getSource();
         	panel.setStyle("-fx-background-color:transparent;");
         	System.out.println(id);
         } 
      }; 
      
      EventHandler<MouseEvent> eventClickLateralMenu = new EventHandler<MouseEvent>() { 
          @Override 
          public void handle(MouseEvent event) {
          	String id =((Pane) event.getSource()).getId();
          	Pane panel = (Pane) event.getSource();
          	if(id.equals("pnLateralTicket")) {
          		pnTicket.setVisible(true);
          		pnTicket.toFront();
          	}else if(id.equals("pnLateralOrden")) {
          		pnOrden.setVisible(true);

          		pnOrden.toFront();
          	}else if(id.equals("pnLateralReserva")) {
          		pnReservacion.setVisible(true);

          		pnReservacion.toFront();
          	}else if(id.equals("pnLateralSalir")) {
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
         
         private void actualizarTablaReservas() {
        	 List<ReservaTableItem> reservas = new ArrayList<>();
        	 ((List<Reservations>) Main.contexto.get("reservas")).forEach(r ->{
        		ReservaTableItem item = new ReservaTableItem(r.getTable(), r.getUsername(), r.getDateReservationString(), r.getConfirmed(), r.getIsTea(), r.getHour()); 
        		reservas.add(item);
        	 });
        	 ObservableList<ReservaTableItem> datos = FXCollections.observableList(reservas);       	 
        	 
        	 	clMesa.setCellValueFactory(new PropertyValueFactory<ReservaTableItem, String>("Mesa"));
        	    
        	    clUsuario.setCellValueFactory(new PropertyValueFactory<ReservaTableItem, String>("Usuario"));
        	    
        	    clFecha.setCellValueFactory(new PropertyValueFactory<ReservaTableItem, String>("Fecha"));
        	    
        	    clConfirmado.setCellValueFactory(new PropertyValueFactory<ReservaTableItem, String>("Confirmado"));
        	    
        	     clTe_comida.setCellValueFactory(new PropertyValueFactory<ReservaTableItem, String>("Te_Comida"));
        	    
        	     clHora.setCellValueFactory(new PropertyValueFactory<ReservaTableItem, String>("Hora"));
        	    
        	 /*TableColumn<ReservaTableItem, String> mesa = new TableColumn<>("Mesa");
        	 mesa.setCellValueFactory(new PropertyValueFactory<ReservaTableItem, String>("Mesa"));
        	 
        	  TableColumn<ReservaTableItem, String> usuario = new TableColumn<>("Usuario");
        	 mesa.setCellValueFactory(new PropertyValueFactory<ReservaTableItem, String>("Usuario"));
        	 
        	 
       	  	TableColumn<ReservaTableItem, String> fecha = new TableColumn<>("Fecha");
        	 mesa.setCellValueFactory(new PropertyValueFactory<ReservaTableItem, String>("Fecha"));
        	 
        	 TableColumn<ReservaTableItem, String> confirmado = new TableColumn<>("Confirmado");
        	 mesa.setCellValueFactory(new PropertyValueFactory<ReservaTableItem, String>("Confirmado"));
        	 
        	 TableColumn<ReservaTableItem, Boolean> te_Comida = new TableColumn<>("Te_Comida");
        	 mesa.setCellValueFactory(new PropertyValueFactory<ReservaTableItem, String>("Te_Comida"));
        	 
        	 TableColumn<ReservaTableItem, String> hora = new TableColumn<>("Hora");
        	 mesa.setCellValueFactory(new PropertyValueFactory<ReservaTableItem, String>("Hora"));       	 
        	*/
        	 
        /*	 tbReservacion.getColumns().add(mesa);
        	 tbReservacion.getColumns().add(usuario);
        	 tbReservacion.getColumns().add(fecha);
        	 tbReservacion.getColumns().add(confirmado);
        	 tbReservacion.getColumns().add(te_Comida);
        	 tbReservacion.getColumns().add(hora);*/
        	 datos.forEach(d -> tbReservacion.getItems().add(d));
        	 //tbReservacion.setItems(datos);
        	
         	//tbReservacion.setItems(reservas);
         	
         }
         
}

