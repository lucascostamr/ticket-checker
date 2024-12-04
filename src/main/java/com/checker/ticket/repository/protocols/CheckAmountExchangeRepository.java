package com.checker.ticket.repository.protocols;

import java.sql.SQLException;

public interface CheckAmountExchangeRepository {
    public int getAmountExchangeByClientId(int clientId) throws SQLException;
}
