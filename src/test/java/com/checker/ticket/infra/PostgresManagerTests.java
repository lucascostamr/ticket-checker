package com.checker.ticket.infra;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

public class PostgresManagerTests {
    @Test
    void should_return_valid_connection_on_success() throws SQLException{
        Connection conn = PostgresManager.connect();
        assertTrue(conn.isValid(0));
    }

    @Test
    void should_close_connection_on_success() throws SQLException{
        Connection conn = PostgresManager.connect();
        PostgresManager.disconnect();
        assertTrue(conn.isClosed());
    }
}