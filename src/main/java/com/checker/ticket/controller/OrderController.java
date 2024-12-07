package com.checker.ticket.controller;

import org.springframework.http.ResponseEntity;

import com.checker.ticket.controller.protocols.Controller;
import com.checker.ticket.controller.protocols.Request;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.checker.ticket.services.protocols.CheckAmountOrders;

@RestController
public class OrderController implements Controller{

    @Autowired
    private CheckAmountOrders checkAmountOrders;

    @Override
    @CrossOrigin(origins = "*")
    @PostMapping("/order")

    public ResponseEntity<Object> handle(@RequestBody Request request) {
        try {
            int clientId = (int) request.clientId();
            int response = checkAmountOrders.getAmountOrders(clientId);
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
