package com.server.ZeroZinema.controller;

import com.server.ZeroZinema.model.Ticket;
import com.server.ZeroZinema.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TicketController {
    @Autowired
    private TicketRepository ticketRepository;

    @PostMapping("/ticket")
    Ticket newTicket(@RequestBody Ticket newTicket){
        return ticketRepository.save(newTicket);
    }

    @GetMapping("/allTickets")
    List<Ticket> getAllTickets(){
        return ticketRepository.findAll();
    }

}
