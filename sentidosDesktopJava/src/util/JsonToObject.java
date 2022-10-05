package util;

import com.google.gson.Gson;

import model.Customer;
import model.LoginResponse;
import model.OrderList;
import model.ReservaList;
import model.Reservations;

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
	
	public static ReservaList jsonToReservaResponse(String json) {
		Gson gson=new Gson();
		System.out.println("json : "+json);
		ReservaList list =gson.fromJson(json, ReservaList.class);
		System.out.println("json objeto: "+list.toString());
		return list;
	}
	
	public static String reservaToJson(Reservations res) {
		Gson gson=new Gson();
		String json =gson.toJson(res);
		return json;
	}
}
