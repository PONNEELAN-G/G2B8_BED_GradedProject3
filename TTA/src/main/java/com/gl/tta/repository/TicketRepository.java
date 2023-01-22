package com.gl.tta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.tta.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long>{

}
