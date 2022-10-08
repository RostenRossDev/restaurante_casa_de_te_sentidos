package Servicios;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import constantes.Constantes;
import home.Main;
import model.LoginResponse;
import model.OrderList;
import model.OrderResponse;
import model.ReservaList;
import model.ReservaTableItem;
import model.Reservations;
import util.JsonToObject;

public class HttpReservaService {

	public ReservaList todasLasReservas() {
		String userToken = ((LoginResponse) Main.contexto.get("login")).getAccess_token();

		System.out.println("EL LOGGGGIN : " + ((LoginResponse) Main.contexto.get("login")));
		ReservaList reservaList = todasLasReservasResponse(userToken);
		Main.contexto.put("reservas", reservaList.getReservas());
		return reservaList;
	}

	private ReservaList todasLasReservasResponse(String token) {
		String reservasUrl = Constantes.BASE_URL + Constantes.RESERVAS + "/desktop/all";
		System.out.println("token: " + token);
		try {
			URL url = new URL(reservasUrl);
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
				System.out.println("respuesta: " + sb.toString());
				ReservaList reservasList = JsonToObject.jsonToReservaResponse(sb.toString());

				System.out.println("response: " + reservasList.toString());
				return reservasList;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ReservaList();

		}
		return new ReservaList();
	}

	public Boolean actualizarReserva() {
		return Boolean.TRUE;
	}

	public Boolean borrarReserva(String id) {
		String reservasUrl = Constantes.BASE_URL + Constantes.RESERVAS + "";
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

	public Boolean actualizarReserva(String reserva) {

		String reservasUrl = Constantes.BASE_URL + Constantes.RESERVAS + "";
		LoginResponse user = (LoginResponse) Main.contexto.get("login");
		System.out.println(reserva);
		try {
			URL url = new URL(reservasUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("PUT");
			conn.setRequestProperty("Authorization", "Bearer " + user.getAccess_token());
			conn.setRequestProperty("Content-Type", "application/json");

			conn.setDoOutput(true);

			OutputStream os = conn.getOutputStream();
			byte[] input = reserva.getBytes();
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
			ReservaList reservasList = JsonToObject.jsonToReservaResponse(sb.toString());
			System.out.println(sb.toString());
			if (HttpURLConnection.HTTP_OK == conn.getResponseCode()) {
				Main.contexto.put("reservas", reservasList.getReservas());
				return true;
			}			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
