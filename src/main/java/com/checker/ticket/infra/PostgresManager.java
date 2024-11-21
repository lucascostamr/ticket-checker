package com.checker.ticket.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class PostgresManager {
    private static Connection conn;

    private PostgresManager() {
    }

    private static void init() throws SQLException {
        String url = String.format(
            "jdbc:postgresql://%s/%s",
            System.getenv("DB_HOST"),
            System.getenv("DB_DATABASE")
        );
        Properties props = new Properties();
        props.setProperty("user", System.getenv("DB_USER"));
        props.setProperty("password", System.getenv("DB_PASSWORD"));
        props.setProperty("ssl", "false");

        conn = DriverManager.getConnection(url, props);
    }

    public static Connection connect() throws SQLException{
        if(conn == null || conn.isClosed()) init();
        return conn;
    }
}