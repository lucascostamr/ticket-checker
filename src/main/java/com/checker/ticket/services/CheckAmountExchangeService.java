package com.checker.ticket.services;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.checker.ticket.model.Client;
import com.checker.ticket.repository.protocols.CheckAmountExchangeRepository;
import com.checker.ticket.services.protocols.CheckAmountExchanges;

@Service
class CheckAmountExchangesService implements CheckAmountExchanges {

    @Autowired
    @Qualifier("json-repository")
    private CheckAmountExchangeRepository checkAmountExchangeRepository;

    @Override
    public int getAmountExchange(int clientId) throws Exception{
        int amountExchange = this.checkAmountExchangeRepository.getAmountExchangeByClientId(clientId);
        Client exchange = new Client(amountExchange);
        return exchange.getAmountExchange();
    }
}