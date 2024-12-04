package com.checker.ticket.services.protocols;

import java.sql.SQLException;

public interface CheckAmountExchanges {
    public int getAmountExchange(int clientdId) throws SQLException;
}
