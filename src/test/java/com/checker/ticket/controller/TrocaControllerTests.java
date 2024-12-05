package com.checker.ticket.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.checker.ticket.controller.protocols.Controller;
import com.checker.ticket.controller.ExchangeController;

public class TrocaControllerTests {
    @Test
    void should_return_bad_request_on_invalid_param() throws SQLException{
        ExchangeController sut = new ExchangeController();
        
    }
}
