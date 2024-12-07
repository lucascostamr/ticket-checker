package com.checker.ticket.repository.protocols;

public interface CheckAmountOrdersRepository {
    public int getAmountOrdersByClientId(int clientId) throws Exception;
}
