package com.glearning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glearning.dao.TicketRepository;
import com.glearning.model.Ticket;

@Service
public class TicketServiceImpl implements TicketService{
	@Autowired
	private TicketRepository ticketRepository;
	
	@Override
	public List<Ticket> fetchAllTicket() {
		return ticketRepository.findAll();
	}

	@Override
	public List<Ticket> searchAllTicket(String title,String description) {
		return ticketRepository.findAllByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(title,description);
	}

	@Override
	public void saveTicket(Ticket ticket) {
		ticketRepository.save(ticket);
	}

	@Override
	public void deleteTicketById(int id) {
		ticketRepository.deleteById(id);
	}

	@Override
	public Ticket getTicketById(int id) {
		return ticketRepository.findById(id).get();
	}

}
