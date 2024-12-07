package com.checker.ticket.services.protocols;

public interface CheckAmountTickets {
    public boolean hasEnoughTickets(int clientdId) throws Exception;
}
