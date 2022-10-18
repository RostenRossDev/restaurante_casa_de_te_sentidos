package Servicios;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import constantes.Constantes;
import home.Main;
import model.LoginResponse;
import model.OrderList;
import model.ReservaList;
import model.TicketList;
import util.JsonToObject;

public class HttpOrdenService {
	public OrderList todasLasOrdenes() {
		System.out.println("ordenes");
		String userToken = ((LoginResponse) Main.contexto.get("login")).getAccess_token();

		System.out.println("EL LOGGGGIN : " + ((LoginResponse) Main.contexto.get("login")));
		OrderList orderList = todosLasOrdenesResponse(userToken);
		Main.contexto.put("ordenes", orderList.getOrders());
		return orderList;
	}

	private OrderList todosLasOrdenesResponse(String token) {
		System.out.println("por buscar los tickets");
		String ticketUrl = Constantes.BASE_URL + Constantes.ORDENES + "/desktop/all";
		System.out.println("token: " + token);
		try {
			URL url = new URL(ticketUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Authorization", "Bearer " + token);

			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			StringBuilder sb = new StringBuilder();
			String line;

			while ((line = br.readLine()) != null) {
				System.out.println("line: "+line);
				sb.append(line + "\n");
			}
			br.close();

			if (HttpURLConnection.HTTP_OK == conn.getResponseCode()) {
				System.out.println("respuesta ordenes: " + sb.toString());
				OrderList orderList = JsonToObject.jsonToOrderList(sb.toString());
				System.out.println("orderList: " +orderList);

				return orderList;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new OrderList();

		}
		return new OrderList();
	}
	
	
	public Boolean actualizarTicket(String json) {
		String ticketUrl = Constantes.BASE_URL + Constantes.TICKET + "";
		LoginResponse user = (LoginResponse) Main.contexto.get("login");
		System.out.println(json);

		
		try {
			URL url = new URL(ticketUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("PUT");
			conn.setRequestProperty("Authorization", "Bearer " + user.getAccess_token());
			conn.setRequestProperty("Content-Type", "application/json");

			conn.setDoOutput(true);

			OutputStream os = conn.getOutputStream();
			byte[] input = json.getBytes();
			os.write(input, 0, input.length);
			os.flush();
		
			Reader reader = new InputStreamReader(conn.getInputStream());
			BufferedReader br = new BufferedReader(reader);
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");												
			} 
			br.close();
			TicketList ticketList = JsonToObject.jsonToTicketList(sb.toString());
			System.out.println(sb.toString());
			if (HttpURLConnection.HTTP_OK == conn.getResponseCode()) {
				Main.contexto.put("ordenes", ticketList.getTickets());
				return true;
			}			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	public Boolean borrarTicket(String id) {
		String reservasUrl = Constantes.BASE_URL + Constantes.TICKET + "";
		LoginResponse user = (LoginResponse) Main.contexto.get("login");
		System.out.println(id);
		try {
			URL url = new URL(reservasUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("DELETE");
			// conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Authorization", "Bearer " + user.getAccess_token());
			conn.setRequestProperty("Content-Type", "application/json");

			conn.setDoOutput(true);
			OutputStream os = conn.getOutputStream();
			os.write(id.getBytes());
			os.flush();

			if (HttpURLConnection.HTTP_OK == conn.getResponseCode()) {

				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				StringBuilder sb = new StringBuilder();
				String line;

				while ((line = br.readLine()) != null) {
					sb.append(line + "\n");
				}
				br.close();
				
				TicketList ticketList = JsonToObject.jsonToTicketList(sb.toString());
				Main.contexto.put("tickets", ticketList.getTickets());
				System.out.println("response: " + HttpURLConnection.HTTP_OK);
				return true;
			}
			System.out.println("response: ok");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("response: no ok");

			return false;

		}
		return false;
	}
	
	
	public HashMap<String, Object> nuevaOrden(String json) {
		HashMap<String, Object> response = new HashMap<String, Object>();
		
		String reservasUrl = Constantes.BASE_URL + Constantes.ORDENES + "/desktop";
		LoginResponse user = (LoginResponse) Main.contexto.get("login");
		System.out.println(json);
		try {
			URL url = new URL(reservasUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Authorization", "Bearer " + user.getAccess_token());
			conn.setRequestProperty("Content-Type", "application/json");

			conn.setDoOutput(true);

			OutputStream os = conn.getOutputStream();
			byte[] input = json.getBytes();
			os.write(input, 0, input.length);
			os.flush();
		
			Reader reader = new InputStreamReader(conn.getInputStream());
			BufferedReader br = new BufferedReader(reader);
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");												
			} 
			br.close();
			System.out.println(sb.toString());
			if (HttpURLConnection.HTTP_OK == conn.getResponseCode()) {
				OrderList orderList = JsonToObject.jsonToOrderList(sb.toString());
				Main.contexto.put("ordenes", orderList.getOrders());
				response.put("code", conn.getResponseCode());
				return response;
			}else {
				response.put("code", conn.getResponseCode());
				response.put("msg", JsonToObject.jsonToMsgResponse(sb.toString()).getMsg());
				return response;
			}
		}catch (Exception e) {
			e.printStackTrace();			
		}
		response.put("code", 500);
		response.put("msg", "Ocurrio un error, intente nuevamente.");
		return response;	
	}
}
