package model;

import java.util.List;

public class ReservaList {
	private List<Reservations> reservations;

	
	public ReservaList() {
		super();
	}

	public ReservaList(List<Reservations> reservas) {
		super();
		this.reservations = reservas;
	}

	public List<Reservations> getReservas() {
		return reservations;
	}

	public void setReservas(List<Reservations> reservas) {
		this.reservations = reservas;
	}

	@Override
	public String toString() {
		return "ReservasList [reservas=" + reservations + "]";
	}
}
