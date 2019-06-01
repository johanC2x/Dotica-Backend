package com.devswpro.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devswpro.model.Ticket;

public interface ITicketDAO extends JpaRepository<Ticket, Integer>{

}
