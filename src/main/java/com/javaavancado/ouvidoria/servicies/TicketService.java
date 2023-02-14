package com.javaavancado.ouvidoria.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.javaavancado.ouvidoria.entities.Ticket;
import com.javaavancado.ouvidoria.repositories.TicketRepository;
import com.javaavancado.ouvidoria.servicies.exceptions.ResourceNotFoundException;

@Service
public class TicketService {
	
	@Autowired
	private TicketRepository repository;
	
	public Ticket insert(Ticket ticket) {
		return repository.save(ticket);
	}
	
	public List<Ticket> findAll() {
		return repository.findAll();
	}
	
	public Ticket findById(Long id) {
		Optional<Ticket> obj = repository.findById(id);
		return obj.get();
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
//		catch(ConstraintViolationException e) {
//			throw new DatabaseException(e.getMessage());
//		}
	}
}