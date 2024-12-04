package com.checker.ticket.repository.protocols;

import java.sql.SQLException;

public interface CheckAmountOrdersRepository {
    public int getAmountOrdersByClientId(int clientId) throws SQLException;
}
