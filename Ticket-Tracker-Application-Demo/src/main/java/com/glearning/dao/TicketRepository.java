package com.glearning.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.glearning.model.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer>{
	List<Ticket> findAllByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String title,String description);
}
