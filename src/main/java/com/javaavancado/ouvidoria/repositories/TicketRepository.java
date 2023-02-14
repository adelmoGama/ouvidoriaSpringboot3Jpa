package com.javaavancado.ouvidoria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaavancado.ouvidoria.entities.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long>  {

}