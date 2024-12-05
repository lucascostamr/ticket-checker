package com.checker.ticket.services;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.checker.ticket.model.Ticket;
import com.checker.ticket.repository.protocols.CheckAmountTicketsRepository;
import com.checker.ticket.services.protocols.CheckAmountTickets;

@Service
class CheckAmountTicketsService implements CheckAmountTickets {

    @Autowired
    private CheckAmountTicketsRepository checkAmountTicketsRepository;

    @Override
    public boolean hasEnoughTickets(int clientId) throws SQLException{
        int amountTickets = this.checkAmountTicketsRepository.getAmountTickets(clientId);
        Ticket ticket = new Ticket(amountTickets);
        return ticket.hasEnoughTickets();
    }
}