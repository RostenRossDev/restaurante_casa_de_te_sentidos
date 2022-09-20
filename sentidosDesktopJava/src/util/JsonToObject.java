package util;

import com.google.gson.Gson;

import model.Customer;
import model.LoginResponse;
import model.OrderList;

public class JsonToObject {

	
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
}
