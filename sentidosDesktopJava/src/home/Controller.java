package home;

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
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.LoginResponse;
import model.OrderList;
import model.OrderResponse;

import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable , EventHandler<ActionEvent>{

    @FXML
    private VBox pnItems = null;
    
    @FXML
    private Button btnLogin;
    
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
    private Pane pnlCustomer;

    @FXML
    private Pane pnlOrders;

    @FXML
    private Pane pnlOverview;

    @FXML
    private Pane pnlMenus;

    @FXML
    private Pane pnLogin;
    
    @FXML
    private TextField username;
    
    @FXML
    private PasswordField password;
    
    @FXML
    private Label warning;
    
    Stage stage;    
  
    private HttpService http = new HttpService();
    
    @Override
	public void handle(ActionEvent actionEvent) {
		// TODO Auto-generated method stub
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
    	
	}
    
    private void verifyLogin() {
    	LoginResponse login =(LoginResponse) Main.contexto.get("login");
    	
    	if(login.getAccess_token() != null) {
    		setBtnVisible();
    		rellenarOrdenes();
    	}else{
    		warning.setVisible(true);
    		warning.setText("Ocurrio un error, intente nuevamente.");
    	}
    }
          
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	
    	loginToFrontt();
    	btnClose.setOnAction(this);
    	btnLogin.setOnAction(this);
    	warning.setVisible(false);	   	

    }

    private void loginToFrontt() {
    	btnCustomers.setVisible(false);
    	btnMenus.setVisible(false);
    	btnOverview.setVisible(false);
    	btnOrders.setVisible(false);
    	btnPackages.setVisible(false);
    	btnSignout.setVisible(false);
    	pnLogin.setStyle("-fx-background-color : #1620A1");
    	pnLogin.toFront();    	
    }
    
    private void setBtnVisible() {
    	btnCustomers.setVisible(true);
    	btnMenus.setVisible(true);
    	btnOverview.setVisible(true);
    	btnOrders.setVisible(true);
    	btnPackages.setVisible(true);
    	btnSignout.setVisible(true);    	
    	pnLogin.setVisible(false);
    	pnlOverview.setStyle("-fx-background-color : #02030A");
    	pnlOverview.toFront();
    }

    public void handleClicks(ActionEvent actionEvent) {
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
        }                        
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
	                for(int x=0; x< childs.size();x++) {
	                	System.out.println(childs.get(x).getId());
	                	
	                	if("fecha".equals(childs.get(x).getId())) {	                		
	                		Date date = order.getCreateAt();	                		
	                		Calendar calendar = new GregorianCalendar();
	                		calendar.setTime(date);
	                		int year = calendar.get(Calendar.YEAR);
	                		//Add one to month {0 - 11}
	                		int month = calendar.get(Calendar.MONTH) + 1;
	                		int day = calendar.get(Calendar.DAY_OF_MONTH);
	                		
	                		System.out.println("entramos");
	                		Label label = (Label) childs.get(x);
	                		label.setText(day+"/"+month+"/"+year);
	                		System.out.println("fechaa: "+label.getText());
	                		load.getChildren().remove(x);
	                		load.getChildren().add(label);
	                		System.out.println("llegamos: ");
	                		
	                	}else if("mesa".equals(childs.get(x).getId())) {
	                		Label label = (Label) childs.get(x);
	                		label.setText("1");
	                		load.getChildren().remove(x);
	                		load.getChildren().add(label);
	                	}else if("total".equals(childs.get(x).getId())) {
	                		Label label = (Label) childs.get(x);
	                		label.setText("$523,50");
	                		load.getChildren().remove(x);
	                		load.getChildren().add(label);
	                	}else if ("estado".equals(childs.get(x).getId())) {
	                		Button button = (Button) childs.get(x);
	                		button.setText("pendiente");
	                		load.getChildren().remove(x);
	                		load.getChildren().add(button);
	                	}
	                	System.out.println("Row "+i+" Child index: "+x);
	                }	             
	                
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
	
}
