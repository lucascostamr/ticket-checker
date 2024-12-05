package com.checker.ticket.services;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.checker.ticket.model.Client;
import com.checker.ticket.repository.protocols.CheckAmountExchangeRepository;
import com.checker.ticket.services.protocols.CheckAmountExchanges;

@Service
class CheckAmountExchangesService implements CheckAmountExchanges {

    @Autowired
    private CheckAmountExchangeRepository checkAmountExchangeRepository;

    @Override
    public int getAmountExchange(int clientId) throws SQLException{
        int amountExchange = this.checkAmountExchangeRepository.getAmountExchangeByClientId(clientId);
        Client exchange = new Client(amountExchange);
        return exchange.getAmountExchange();
    }
}