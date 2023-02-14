package com.javaavancado.ouvidoria.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.javaavancado.ouvidoria.entities.Ticket;
import com.javaavancado.ouvidoria.entities.User;
import com.javaavancado.ouvidoria.entities.enums.TicketType;
import com.javaavancado.ouvidoria.repositories.TicketRepository;
import com.javaavancado.ouvidoria.repositories.UserRepository;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TicketRepository ticketRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "fulano1_", "132", "Fulano 1", "fulano1@gmail.com", "988774455");
		User u2 = new User(null, "fulano2_", "456", "Fulano 2", "fulano2@gmail.com", "933221166");
		
		Ticket t1 = new Ticket(null, Instant.parse("2022-08-26T20:55:32Z"), u1, TicketType.ELOGIO, "Teste 1");
		Ticket t2 = new Ticket(null, Instant.parse("2023-01-20T12:12:16Z"), u2, TicketType.SUGESTAO,"Teste 2");
		Ticket t3 = new Ticket(null, Instant.parse("2022-11-17T09:18:46Z"), u1, TicketType.RECLAMACAO, "Teste 3");
		Ticket t4 = new Ticket(null, Instant.parse("2023-01-28T10:25:02Z"), u2, TicketType.SUGESTAO, "Teste 4");
		Ticket t5 = new Ticket(null, Instant.parse("2023-02-13T14:42:37Z"), u2, TicketType.ELOGIO,"Teste 5");
		
		userRepository.saveAllAndFlush(Arrays.asList(u1, u2));
		ticketRepository.saveAll(Arrays.asList(t1, t2, t3, t4, t5));
	}

}