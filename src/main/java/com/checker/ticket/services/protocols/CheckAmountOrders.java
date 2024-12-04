package com.checker.ticket.services.protocols;

import java.sql.SQLException;

public interface CheckAmountOrders {
    public int getAmountOrders(int clientdId) throws SQLException;
}
