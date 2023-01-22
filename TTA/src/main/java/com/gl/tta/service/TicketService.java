package com.gl.tta.service;

import java.util.List;

import com.gl.tta.entity.Ticket;

public interface TicketService {

	List<Ticket> listTickets();

	Ticket saveTicket(Ticket ticket);

	Ticket editTicket(Ticket ticket);

	Ticket getTicketById(long id);

	void deleteTicketById(long id);

	public List<Ticket> getATicket(String details);

}
