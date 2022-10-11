package Servicios;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;

import constantes.Constantes;
import home.Main;
import model.LoginResponse;
import model.ReservaList;
import model.TicketList;
import util.JsonToObject;

public class HttpTicketService {
    public TicketList todosLosTickets() {
		System.out.println("tickets");
		String userToken = ((LoginResponse) Main.contexto.get("login")).getAccess_token();

		System.out.println("EL LOGGGGIN : " + ((LoginResponse) Main.contexto.get("login")));
		TicketList ticketList = todosLosTicketsResponse(userToken);
		Main.contexto.put("tickets", ticketList.getTickets());
		return ticketList;
	}

	private TicketList todosLosTicketsResponse(String token) {
		System.out.println("por buscar los tickets");
		String ticketUrl = Constantes.BASE_URL + Constantes.TICKET + "/desktop/all";
		System.out.println("token: " + token);
		try {
			URL url = new URL(ticketUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			// conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Authorization", "Bearer " + token);

			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			StringBuilder sb = new StringBuilder();
			String line;

			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			br.close();

			if (HttpURLConnection.HTTP_OK == conn.getResponseCode()) {
				System.out.println("respuesta tickets: " + sb.toString());
				TicketList ticketList = JsonToObject.jsonToTicketList(sb.toString());
				System.out.println("ticketsList: " +ticketList);

				return ticketList;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new TicketList();

		}
		return new TicketList();
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
				Main.contexto.put("tickets", ticketList.getTickets());
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
}
