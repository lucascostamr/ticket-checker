package com.checker.ticket.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.checker.ticket.controller.protocols.Controller;
import com.checker.ticket.controller.protocols.Request;
import com.checker.ticket.services.protocols.CheckAmountExchanges;

@RestController
class ExchangeController implements Controller {

    @Autowired
    private CheckAmountExchanges checkAmountExchanges;

    @Override
    @PostMapping("/exchange")

    public ResponseEntity<Object> handle(@RequestBody Request request) {
        try {
            int clientId = request.clientId();
            int response = checkAmountExchanges.getAmountExchange(clientId);
            return ResponseEntity.ok(response);
        } catch (ClassCastException e) {
            return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Invalid Params");
        } catch (PSQLException e) {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("No Client with the ID provided found");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Server Error");
        }
    }
}