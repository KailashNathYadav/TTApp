package com.glearning.service;

import java.util.List;

import com.glearning.model.Ticket;

public interface TicketService {
	List<Ticket> fetchAllTicket();

	List<Ticket> searchAllTicket(String title,String description);

	void saveTicket(Ticket ticket);

	void deleteTicketById(int id);

	Ticket getTicketById(int id);
}
