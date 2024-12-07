package com.checker.ticket.repository.DbClient;

import com.checker.ticket.repository.protocols.CheckAmountTicketsRepository;

import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.checker.ticket.infra.PostgresManager;

@Repository
public class DbCheckAmountTicketsRepository implements CheckAmountTicketsRepository{
    @Override
    public int getAmountTickets(int clientId) throws SQLException{
        Connection conn = PostgresManager.connect();
        String query = "SELECT num_tickets FROM clients WHERE clients.id = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setInt(1, clientId);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getInt("num_tickets");
    }
}
