package com.glearning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.glearning.model.Ticket;
import com.glearning.service.TicketService;

@Controller
public class TicketController {
	@Autowired
	private TicketService ticketService;
	
	@GetMapping("/tickets")
	public String getAllTicket(Model model) {
		List<Ticket> tickets = ticketService.fetchAllTicket();
		model.addAttribute("tickets",tickets);
		return "tickets";
	}
	
	@PostMapping("/tickets/search")
	public String searchAllTicket(Model model,@RequestParam("keyword") String query) {
		List<Ticket> feasibleTickets = ticketService.searchAllTicket(query, query);
		model.addAttribute("tickets",feasibleTickets);
		return "tickets";
	}
	
	@GetMapping("/tickets/newTicket")
	public String createTicketForm(Model model) {
		Ticket ticket = new Ticket();
		model.addAttribute("ticket", ticket);
		model.addAttribute("create", true);
		return "create_or_edit_ticket";
	}

	@GetMapping("/tickets/edit/{id}")
	public String editTicketForm(@PathVariable int id, Model model) {
		Ticket ticket = ticketService.getTicketById(id);
		model.addAttribute("ticket", ticket);
		model.addAttribute("create", false);
		ticketService.deleteTicketById(id);
		return "create_or_edit_ticket";
	}

	@PostMapping("/tickets")
	public String save(@ModelAttribute("ticket") Ticket ticket) {
		ticketService.saveTicket(ticket);
		return "redirect:/tickets";
	}

	@GetMapping("/tickets/{id}")
	public String deleteTicket(@PathVariable int id) {
		ticketService.deleteTicketById(id);
		return "redirect:/tickets";
	}
}
