package com.checker.ticket.repository.protocols;

import java.sql.SQLException;

public interface CheckAmountTicketsRepository {
    public int getAmountTickets(int clientId) throws SQLException;
}
