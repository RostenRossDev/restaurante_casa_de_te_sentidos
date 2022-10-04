package Servicios;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
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
import model.Reservations;
import util.JsonToObject;
public class HttpReservaService {

	
	
	public ReservaList todasLasReservas() {
		String userToken =((LoginResponse) Main.contexto.get("login")).getAccess_token();

		System.out.println("EL LOGGGGIN : "+((LoginResponse) Main.contexto.get("login")));
		ReservaList reservaList = todasLasReservasResponse(userToken);
		Main.contexto.put("reservas", reservaList.getReservas());
		return reservaList;
	}
	
	private ReservaList todasLasReservasResponse(String token) {
		String reservasUrl = Constantes.BASE_URL+Constantes.RESERVAS+"all";
		System.out.println("token: "+token);
		try {
			URL url = new URL(reservasUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			//conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Authorization", token);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			StringBuilder sb = new StringBuilder();
			String line;

			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			br.close();

			if (HttpURLConnection.HTTP_OK == conn.getResponseCode()) {
				System.out.println("respuesta: "+sb.toString());
				ReservaList reservasList = JsonToObject.jsonToReservaResponse(sb.toString());
				
				System.out.println("response: "+reservasList.toString());
				return reservasList;
			}
		} catch (Exception e) {
			e.printStackTrace();
			 return  new ReservaList();
			 		
		}
		return  new ReservaList();
	}
}
