package com.gl.tta.service.impl;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.gl.tta.entity.Ticket;
import com.gl.tta.repository.TicketRepository;
import com.gl.tta.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {

	private TicketRepository ticketRepository;

	public TicketServiceImpl(TicketRepository ticketRepository) {
		this.ticketRepository = ticketRepository;
	}

	public List<Ticket> listTickets() {
		return ticketRepository.findAll();
	}

	public Ticket saveTicket(Ticket ticket) {
		return ticketRepository.save(ticket);
	}

	@Override
	public Ticket editTicket(Ticket ticket) {
		return ticketRepository.save(ticket);
	}

	@Override
	public void deleteTicketById(long id) {
		ticketRepository.deleteById(id);

	}

	@Override
	public Ticket getTicketById(long id) {
		return ticketRepository.getById(id);
	}

	@Override
	public List<Ticket> getATicket(String details) {
		Ticket thisTicket = new Ticket();
		thisTicket.setDetails(details);
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("Details", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "description", "date");
		Example<Ticket> example = Example.of(thisTicket, exampleMatcher);
		return ticketRepository.findAll();
	}

}
