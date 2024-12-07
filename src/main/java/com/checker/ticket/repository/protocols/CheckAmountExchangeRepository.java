package com.checker.ticket.repository.protocols;

public interface CheckAmountExchangeRepository {
    public int getAmountExchangeByClientId(int clientId) throws Exception;
}
