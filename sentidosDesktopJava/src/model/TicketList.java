package model;

import java.util.List;

public class TicketList {
    private List<Ticket> tickets;

	
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
