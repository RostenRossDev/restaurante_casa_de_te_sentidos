package util;

import com.google.gson.Gson;

import model.Customer;
import model.LoginResponse;
import model.OrderList;
import model.ReservaList;
import model.Reservations;
import model.Ticket;
import model.TicketList;

public class JsonToObject {

	//Login response 
	public static LoginResponse jsonToLoginResponse (String json) {

		Gson gson=new Gson();		
		return gson.fromJson(json, LoginResponse.class);     				
	}
	
	public static OrderList jsonToOrderResponse (String json) {
		Gson gson=new Gson();
		OrderList list =gson.fromJson(json, OrderList.class);
		return list;
	}
	
	public static Customer jsonToCustomerResponse (String json) {
		Gson gson=new Gson();
		Customer customer =gson.fromJson(json, Customer.class);
		return customer;
	}
	
	
	//reservation response
	
	public static ReservaList jsonToReservaList (String json) {
		Gson gson=new Gson();
		System.out.println("json reserva : "+json);
		ReservaList list =gson.fromJson(json, ReservaList.class);
		System.out.println("json objeto: "+list.toString());
		return list;
	}
	
	public static String reservaToJson(Reservations res) {
		Gson gson=new Gson();
		String json =gson.toJson(res);
		return json;
	}
	
	
	
	// tikcet response	
	public static TicketList jsonToTicketList (String json) {
		Gson gson=new Gson();
		System.out.println("json ticket : "+json);
		TicketList list =gson.fromJson(json, TicketList.class);
		System.out.println("cantidad de items en lista tikets: "+list.getTickets().size());
		System.out.println("json objeto: "+list.toString());
		return list;
	}
	
	public static String ticketToJson(Ticket res) {
		Gson gson=new Gson();
		String json =gson.toJson(res);
		return json;
	}
	
	// ordern
	public static OrderList jsonToOrderList (String json) {
		Gson gson=new Gson();
		System.out.println("json OrderList : "+json);
		OrderList list =gson.fromJson(json, OrderList.class);
		System.out.println("cantidad de items en lista tikets: "+list.getOrders().size());
		System.out.println("json objeto: "+list.toString());
		return list;
	}
}
