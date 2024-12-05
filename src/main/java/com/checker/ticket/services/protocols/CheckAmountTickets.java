package com.checker.ticket.services.protocols;

import java.sql.SQLException;

public interface CheckAmountTickets {
    public boolean hasEnoughTickets(int clientdId) throws SQLException;
}
