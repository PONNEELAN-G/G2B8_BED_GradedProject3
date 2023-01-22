package com.gl.tta.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.gl.tta.entity.Ticket;
import com.gl.tta.service.TicketService;

@Controller
public class TicketController {

	private TicketService ticketService;

	public TicketController(TicketService ticketService) {
		this.ticketService = ticketService;
	}

	@GetMapping("/tickets")
	public String listTickets(Model model) {
		List<Ticket> tickets = ticketService.listTickets();
		model.addAttribute("tickets", tickets);
		return "tickets";
	}

	@GetMapping("/tickets/edit/{id}")
	public String editButtonClicked(@PathVariable long id, Model model) {
		Ticket selectedTicket = ticketService.getTicketById(id);
		model.addAttribute("ticket", selectedTicket);
		return "edit-ticket";
	}

	@PostMapping("/tickets/{id}")
	public String submitButtonClickedForEditTicket(@PathVariable long id, @ModelAttribute("ticket") Ticket ticket) {
		Ticket existingTicketObj = ticketService.getTicketById(id);

		existingTicketObj.setId(ticket.getId());
		existingTicketObj.setDetails(ticket.getDetails());
		existingTicketObj.setDescription(ticket.getDescription());
		existingTicketObj.setDate(ticket.getDate());

		ticketService.editTicket(ticket);
		return "redirect:/tickets";
	}

	@GetMapping("/tickets/{id}")
	public String deleteTicket(@PathVariable long id) {
		ticketService.deleteTicketById(id);
		return "redirect:/tickets";
	}

	@GetMapping("/tickets/new")
	public String newTicketButtonClicked(Model model) {
		Ticket ticket = new Ticket();
		model.addAttribute("ticket", ticket);
		return "new-ticket";
	}

	@PostMapping("/tickets")
	public String submitButtonClickedForNewTicket(@ModelAttribute("ticket") Ticket ticket) {
		ticketService.saveTicket(ticket);
		return "redirect:/tickets";
	}

}
