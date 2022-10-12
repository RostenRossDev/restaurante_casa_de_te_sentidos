package model;

import java.util.List;

public class TicketList {
<<<<<<< HEAD
	private List<Ticket> tickets;
=======
    private List<Ticket> tickets;
>>>>>>> 462d7f38d540769c5f2c284744df3f5be1748b90

	
	public TicketList() {
		super();
	}

	public TicketList(List<Ticket> tickets) {
		super();
		this.tickets = tickets;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	@Override
	public String toString() {
		return tickets.toString();
	}
}
