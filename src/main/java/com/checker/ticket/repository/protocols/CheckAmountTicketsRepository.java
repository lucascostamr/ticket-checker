package com.checker.ticket.repository.protocols;

public interface CheckAmountTicketsRepository {
    public int getAmountTickets(int clientId) throws Exception;
}
