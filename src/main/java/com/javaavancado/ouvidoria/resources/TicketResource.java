package com.javaavancado.ouvidoria.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.javaavancado.ouvidoria.entities.Ticket;
import com.javaavancado.ouvidoria.servicies.TicketService;

@RestController
@RequestMapping(value = "/tickets")
public class TicketResource {
	
	@Autowired
	private TicketService service;
	
	@PostMapping
	public ResponseEntity<Ticket> insert(@RequestBody Ticket ticket) {
		ticket = service.insert(ticket);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ticket.getId()).toUri();
		return ResponseEntity.created(uri).body(ticket);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Ticket> findById(@PathVariable Long id) {
		Ticket obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<Ticket>> findAll() {
		List<Ticket> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}