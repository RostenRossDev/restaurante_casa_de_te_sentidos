package home;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.LoginResponse;
import model.OrderList;
import model.OrderResponse;
import util.JsonToObject;

public class HttpService {

	public HashMap<String, Object> login(String username, String password) {
		HashMap<String, Object> response = new HashMap<String, Object>();

		String form = "username=" + username + "&password=" + password + "&grant_type=password";

		try {

			LoginResponse resp = makeConnectionLogin(form);
			Main.contexto.put("login", resp);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return response;
	}

	public OrderList orders() {
		OrderList resp;
		try {

			resp = makeConnectionOrder();
			Main.contexto.put("orders", resp);
			return resp;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resp = new OrderList();
			List<OrderResponse> ordersResponse = new ArrayList<OrderResponse>();
			resp.setOrders(ordersResponse);
			return resp;
		}

	}

	private OrderList makeConnectionOrder() throws IOException {
		try {
			
			System.out.println("inicia");
			URL url = new URL("http://127.0.0.1:8080/api/v1/order/");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			LoginResponse user = (LoginResponse) Main.contexto.get("login");
			conn.setRequestMethod("GET");

			conn.setRequestProperty("Authorization", "Bearer " + user.getAccess_token());
			
			Reader reader = new InputStreamReader(conn.getInputStream());
			BufferedReader br = new BufferedReader(reader);
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			br.close();

			if (HttpURLConnection.HTTP_OK == conn.getResponseCode()) {
				OrderList orderResp = JsonToObject.jsonToOrderResponse(sb.toString());
				
				return orderResp;
			}
		} catch (Exception e) {
			// TODO: handle exception
			return new OrderList();
		}

		return new OrderList();
	}

	private LoginResponse makeConnectionLogin(String form) throws IOException {
		try {
			URL url = new URL("http://127.0.0.1:8080/oauth/token");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setRequestProperty("Authorization", "Basic cmVhY3RTZW50aWRvc0FwcDpzZW50aWRvczMzOTk=");
			conn.setDoOutput(true);

			OutputStream output = conn.getOutputStream();
			output.write(form.getBytes());

			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			StringBuilder sb = new StringBuilder();
			String line;

			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			br.close();

			if (HttpURLConnection.HTTP_OK == conn.getResponseCode()) {
				LoginResponse loginResp = JsonToObject.jsonToLoginResponse(sb.toString());
				output.flush();
				output.close();

				return loginResp;
			}
		} catch (Exception e) {
			// TODO: handle exception

			return new LoginResponse();
		}
		return new LoginResponse();
	}
}
