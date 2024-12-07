package com.checker.ticket.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.checker.ticket.model.Order;
import com.checker.ticket.repository.protocols.CheckAmountOrdersRepository;
import com.checker.ticket.services.protocols.CheckAmountOrders;

@Service
class CheckAmountOrdersService implements CheckAmountOrders {

    @Autowired
    @Qualifier("json-orders-repository")
    private CheckAmountOrdersRepository checkAmountOrdersRepository;

    @Override
    public int getAmountOrders(int clientId) throws Exception{
        int amountExchange = this.checkAmountOrdersRepository.getAmountOrdersByClientId(clientId);
        Order exchange = new Order(amountExchange);
        return exchange.getAmountOrders();
    }
}